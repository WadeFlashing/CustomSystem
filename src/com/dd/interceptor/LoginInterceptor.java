package com.dd.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dd.po.User;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String url = request.getRequestURI();
		if(url.indexOf("/login")>=0){
			return true;
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("USER_SESSION");
		if(user!=null){
			return true;
		}
		
		request.setAttribute("msg","Äã»¹Ã»µÇÂ¼£¬ÇëÏÈµÇÂ¼£¡");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exce)
			throws Exception {
		
		
	}
	
}
