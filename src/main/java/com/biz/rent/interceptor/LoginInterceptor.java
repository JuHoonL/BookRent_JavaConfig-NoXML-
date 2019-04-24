package com.biz.rent.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.rent.model.JUserVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// return super.preHandle(request, response, handler);
		HttpSession session = request.getSession();
		
		JUserVO memberVO = (JUserVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) {
			session.removeAttribute("LOGIN_INFO");
			response.sendRedirect("login?LOGIN_MSG=LOGIN_REQ");
			return false;
		}
		return true;
	}
	
	

	
	
}
