package com.gd.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.common.pojo.GdResult;
import com.gd.portal.service.ContentService;

@Controller
public class IndexController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String showIndex(Model model){
		String adJson = contentService.getContentList();
		model.addAttribute("ad1", adJson);
		return "index";
	}
	
	//测试httpclient的post请求
	@RequestMapping(value="/httpclient/post", method=RequestMethod.POST)
	@ResponseBody
	public String testPost(String username, String password){
		return "username:"+username+" password:"+password;
	}
	
}
