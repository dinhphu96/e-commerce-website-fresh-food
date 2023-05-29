package com.poly.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.poly.DAO.AccountDAO;
import com.poly.service.CategoryService;

@Service
public class GlobalInterceptor implements HandlerInterceptor {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	AccountDAO accountDAO;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (request.getRemoteUser() != null) {
			request.setAttribute("user", accountDAO.findByUsername(request.getRemoteUser()));
		}
		request.setAttribute("cates", categoryService.findAll());
	}
}
