package com.hello.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hello.member.vo.MemberVO;

public class BlockPageInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberVO user = (MemberVO) request.getSession().getAttribute("__USER_SESSION_DATA__");
		if(user != null) {
			response.sendRedirect(request.getContextPath() + "/boards");
			return false;
		}
		return true;
	}
}
