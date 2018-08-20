package com.gd.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.gd.common.pojo.GdResult;
import com.gd.common.util.ExceptionUtil;
import com.gd.dao.JedisClient;
import com.gd.rest.service.RedisService;
@Service
public class RedisServiceImpl implements RedisService {
	
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	//内容缓存同步
	public GdResult syncContent(long contentCid) {
		try {
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid + "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		return GdResult.ok();
	}

}
