package com.gd.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	//根据内容分类id，查询内容列表
	public List<GdContent> getContentList(long contentCid) {
		
		GdContentExample example = new GdContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		//执行查询
		List<GdContent> list = contentMapper.selectByExample(example);
		
		return list;
	}

}
