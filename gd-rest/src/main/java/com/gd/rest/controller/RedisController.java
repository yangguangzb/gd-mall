package com.gd.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.common.pojo.GdResult;
import com.gd.rest.service.RedisService;

/**
 * 缓存同步
 * @author zhangbiao
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {
	
	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{contentCid}")
	@ResponseBody
	public GdResult contentCacheSync(@PathVariable Long contentCid){
		GdResult result = redisService.syncContent(contentCid);
		return result;
	}
	
}
