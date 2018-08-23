package com.gd.sso.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.gd.common.pojo.GdResult;
import com.gd.common.util.CookieUtils;
import com.gd.common.util.JsonUtils;
import com.gd.mapper.GdUserMapper;
import com.gd.pojo.GdUser;
import com.gd.pojo.GdUserExample;
import com.gd.pojo.GdUserExample.Criteria;
import com.gd.sso.dao.JedisClient;
import com.gd.sso.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private GdUserMapper gdUserMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;
	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;
	
	/**
	 * 数据校验
	 * content：校验的内容
	 * type：校验的数据类型
	 */
	public GdResult checkData(String content, Integer type) {
		//创建查询条件
		GdUserExample example = new GdUserExample();
		Criteria criteria = example.createCriteria();
		//对数据进行校验，1、2、3分别代表username、phone、email
		if(1 == type){
			criteria.andUsernameEqualTo(content);
		}else if(2 == type){
			criteria.andPhoneEqualTo(content);
		}else{
			criteria.andEmailEqualTo(content);
		}
		//执行查询
		List<GdUser> list = gdUserMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			return GdResult.ok(true);
		}
		
		return GdResult.ok(false);
	}

	public GdResult createUser(GdUser user) {
		user.setUpdated(new Date());
		user.setCreated(new Date());
		//md5加密
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		gdUserMapper.insert(user);
		return GdResult.ok();
	}
	
	//用户登录
	public GdResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		GdUserExample example = new GdUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<GdUser> list = gdUserMapper.selectByExample(example);
		//如果没有此用户名
		if(list == null || list.size() == 0){
			return GdResult.build(400, "用户名或密码错误");
		}
		GdUser user = list.get(0);
		//对比密码
		if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())){
			return GdResult.build(400, "用户名或密码错误");
		}
		//生成token
		String token = UUID.randomUUID().toString();
		//保存用户之前，把用户对象中的密码清空
		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		//设置session的过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		
		//添加写cookie的逻辑，cookie的有效期是关闭浏览器就失效
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		
		//返回token
		return GdResult.ok(token);
	}
	
	//根据token获取用户信息
	public GdResult getUserByToken(String token) {
		//根据token从Redis中查询用户信息
		String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
		//判断是否为空
		if(StringUtils.isBlank(json)){
			return GdResult.build(400, "次session已过期，请重新登陆");
		}
		//更新过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		//返回用户信息
		return GdResult.ok(JsonUtils.jsonToPojo(json, GdUser.class));
	}

	

}
