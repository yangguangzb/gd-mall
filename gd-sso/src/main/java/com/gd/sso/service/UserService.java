package com.gd.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gd.common.pojo.GdResult;
import com.gd.pojo.GdUser;

public interface UserService {
	
	public GdResult checkData(String content, Integer type);
		
	public GdResult createUser(GdUser user);
	
	public GdResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response);
	
	public GdResult getUserByToken(String token);
}
