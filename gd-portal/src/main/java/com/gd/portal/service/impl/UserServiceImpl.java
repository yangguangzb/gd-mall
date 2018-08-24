package com.gd.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gd.common.pojo.GdResult;
import com.gd.common.util.HttpClientUtil;
import com.gd.pojo.GdUser;
import com.gd.portal.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;
	@Value("${SSO_USER_TOKEN}")
	public String SSO_USER_TOKEN;
	@Value("${SSO_DOMAIN_BASE_USRL}")
	public String SSO_DOMAIN_BASE_USRL;
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;
	
	public GdUser getUserByToken(String token) {
		try {
			//调用sso系统的服务,根据token取用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL+SSO_USER_TOKEN+token);
			//把json转换成Gdresult
			GdResult result = GdResult.formatToPojo(json, GdUser.class);
			if(result.getStatus() == 200){
				GdUser user = (GdUser) result.getData();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
