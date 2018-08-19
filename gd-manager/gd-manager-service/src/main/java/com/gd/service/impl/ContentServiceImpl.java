package com.gd.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.common.pojo.GdResult;
import com.gd.mapper.GdContentMapper;
import com.gd.pojo.GdContent;
import com.gd.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private GdContentMapper contentMapper;
	
	@Override
	public GdResult insertContent(GdContent content) {
		//补全pojo内容
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		
		return GdResult.ok();
	}

}
