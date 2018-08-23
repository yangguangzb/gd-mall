package com.gd.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * @author zhangbiao
 */
@Controller
@RequestMapping("/user")
public class PageController {
	
	@RequestMapping("/showRegister")
	public String showRegister(){
		
		return "register";
	}
	
	@RequestMapping("/showLogin")
	public String showLogin(String redirect, Model model){
		model.addAttribute("redirect", redirect);
		return "login";
	}
}
