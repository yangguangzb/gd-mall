package com.gd.rest.service;

import com.gd.common.pojo.GdResult;

public interface RedisService {
	
	public GdResult syncContent(long contentCid);

}
