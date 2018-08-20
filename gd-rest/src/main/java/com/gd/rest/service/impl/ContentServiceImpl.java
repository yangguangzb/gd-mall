package com.gd.rest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gd.common.util.JsonUtils;
import com.gd.dao.JedisClient;
import com.gd.mapper.GdContentMapper;
import com.gd.pojo.GdContent;
import com.gd.pojo.GdContentExample;
import com.gd.pojo.GdContentExample.Criteria;
import com.gd.rest.service.ContentService;

@Service
//内容管理
public class ContentServiceImpl implements ContentService {
	
	@Autowired 
	private GdContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	//根据内容分类id，查询内容列表
	public List<GdContent> getContentList(long contentCid) {
		
		//从缓存中取内容
		try{
			String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid+"");
			if(!StringUtils.isEmpty(result)){
				//把字符串转化为list
				List<GdContent> list = JsonUtils.jsonToList(result, GdContent.class);
				return list;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		GdContentExample example = new GdContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		//执行查询
		List<GdContent> list = contentMapper.selectByExample(example);
		
		//向缓存中添加内容
		try {
			//把list转化为字符串
			String cacheString = JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid+"", cacheString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
