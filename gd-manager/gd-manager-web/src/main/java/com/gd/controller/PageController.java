package com.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 * @description
 * @author zhangbiao
 * @time 2018-6-18 上午11:11:52
 */
@Controller
public class PageController {
	
	/**
	 * 打开首页
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(){
		
		return "index";
	}
	
	/**
	 * 其他页面
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page){
		
		return page;
	}
}
