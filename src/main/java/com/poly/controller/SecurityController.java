package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "<div class=\"alert alert-danger\" role=\"alert\">\r\n"
				+ "  Vui lòng đăng nhập!\r\n"
				+ "</div>");
		return "security/login";
	}
	
	
	@RequestMapping("/security/login/error")
	public String error(Model model) {
		model.addAttribute("message", "<div class=\"alert alert-danger\" role=\"alert\">\r\n"
				+ "  Sai thông tin đăng nhập!\r\n"
				+ "</div>");
		return "security/login";
	}
	
	
	@RequestMapping("/security/logoff/success")
	public String logout(Model model) {
		model.addAttribute("message", "<div class=\"alert alert-info\" role=\"alert\">\r\n"
				+ "  Đăng xuất thành công!\r\n"
				+ "</div>");
		return "security/login";
	}
}
