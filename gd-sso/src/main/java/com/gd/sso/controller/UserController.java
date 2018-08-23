package com.gd.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.common.pojo.GdResult;
import com.gd.common.util.ExceptionUtil;
import com.gd.pojo.GdUser;
import com.gd.sso.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public Object checkData(@PathVariable String param,@PathVariable Integer type,String callback){
		
		GdResult result = null;
		//参数有效性验证
		if(StringUtils.isBlank(param)){
			result = GdResult.build(400, "校验内容不能为空");
		}
		if(type == null){
			result = GdResult.build(400, "校验内容类型不能为空");
		}
		if(type != 1 && type != 2 && type != 3){
			result = GdResult.build(400, "校验类型错误");
		}
		//校验出错
		if(result != null){
			if(callback != null){
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}else{
				return result;
			}
		}
		//调用服务
		try {
			result = userService.checkData(param, type);
		} catch (Exception e) {
			result = GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		if(callback != null){
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}else{
			return result;
		}
		
	}
	
	//用户注册
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public GdResult createUser(GdUser user){
		try {
			GdResult result = userService.createUser(user);
			return result;
		} catch (Exception e) {
			return GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	//用户登录
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public GdResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response){
		try {
			GdResult result = userService.userLogin(username, password, request, response);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping("/token/{token}")
	public Object getUserByToken(@PathVariable String token,String callback){
		GdResult result = null;
		try {
			result = userService.getUserByToken(token);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		//判断是否为jsonp调用
		if(StringUtils.isBlank(callback)){
			return result;
		}else{
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
	}
	
}
