package com.gd.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gd.common.pojo.GdResult;
import com.gd.common.util.HttpClientUtil;
import com.gd.common.util.JsonUtils;
import com.gd.pojo.GdContent;
import com.gd.portal.service.ContentService;
@Service
public class ContentServiceImpl implements ContentService {
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	public String getContentList() {
		//调用服务层的服务
		String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
		//把字符串转换成Gdresult
		try {
			GdResult gdResult = GdResult.formatToList(result,GdContent.class);
			//取内容列表
			List<GdContent> list = (List<GdContent>) gdResult.getData();
			List<Map> resultList = new ArrayList<Map>();
			//创建一个jsp页面要求的pojo列表
			for(GdContent gdContent : list){
				Map map = new HashMap();
				map.put("src", gdContent.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", gdContent.getPic2());
				map.put("widthB", 550);
				map.put("heightB", 240);
				map.put("href", gdContent.getUrl());
				map.put("alt", gdContent.getSubTitle());
				resultList.add(map);
			}
			return JsonUtils.objectToJson(resultList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
