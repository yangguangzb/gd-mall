package com.gd.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gd.common.util.CookieUtils;
import com.gd.pojo.GdUser;
import com.gd.portal.service.UserService;
import com.gd.portal.service.impl.UserServiceImpl;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private UserServiceImpl userService;
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		//返回ModelAndView之后。响应用户之后
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		
		//handler执行之后，返回ModelAndView之前
	}
	
	//在Handler执行之前处理
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//判断用户是否登陆，从cookie中取token
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		//根据token换取用户信息，调用sso系统的接口。
		GdUser user = userService.getUserByToken(token);
		//取不到用户信息
		if(user == null){
			//跳转到登陆页面，把用户请求的url作为参数传递给登陆页面
			response.sendRedirect(userService.SSO_BASE_URL + userService.SSO_PAGE_LOGIN + "?redirect="+ request.getRequestURL());
			return false;
		}
		//取到用户信息，放行，把用户信息放入Request
		request.setAttribute("user", user);
		return true;
	}
	
	
	
}
