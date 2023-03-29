package com.ktdsuniversity.admin.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;

public class BlockPageInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MbrVO admin = (MbrVO)request.getSession().getAttribute("__ADMIN__");
		if(admin != null) {
			response.sendRedirect(request.getContextPath()+"/index");
			return false;
		}
		return true;
	}
}
