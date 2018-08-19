package com.gd.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.common.pojo.GdResult;
import com.gd.common.util.ExceptionUtil;
import com.gd.pojo.GdContent;
import com.gd.rest.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired 
	private ContentService contentService;
	
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public GdResult getContentList(@PathVariable Long contentCategoryId){
		try{
			List<GdContent> list = contentService.getContentList(contentCategoryId);
			return GdResult.ok(list);
		}catch (Exception e) {
			e.printStackTrace();
			return GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
	
}
