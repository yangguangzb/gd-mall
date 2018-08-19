package com.gd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.common.pojo.GdResult;
import com.gd.pojo.GdContent;
import com.gd.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	//保存管理内容信息
	public GdResult insertContent(GdContent content){
		GdResult result = contentService.insertContent(content);
			
		return result;
	}
	
}
