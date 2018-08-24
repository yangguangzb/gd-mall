package com.gd.portal.service;

import com.gd.pojo.GdUser;

public interface UserService {
		
	public GdUser getUserByToken(String token);
	
}
