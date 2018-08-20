package com.gd.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gd.common.pojo.GdResult;
import com.gd.common.util.HttpClientUtil;
import com.gd.mapper.GdContentMapper;
import com.gd.pojo.GdContent;
import com.gd.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private GdContentMapper contentMapper;
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;
	
	@Override
	public GdResult insertContent(GdContent content) {
		//补全pojo内容
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		
		//添加缓存同步逻辑
		try {
			HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return GdResult.ok();
	}

}
