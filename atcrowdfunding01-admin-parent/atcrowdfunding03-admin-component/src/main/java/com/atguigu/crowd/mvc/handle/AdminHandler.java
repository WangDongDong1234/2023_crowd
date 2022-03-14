package com.atguigu.crowd.mvc.handle;

import javax.servlet.http.HttpSession;

import com.atguigu.crowd.service.api.AdminService;
import constant.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.atguigu.crowd.entity.AdminEntity;

@Controller
public class AdminHandler {
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin/do/logout.html")
	public String doLogout(HttpSession session) {

		// 强制Session失效
		session.invalidate();

		return "redirect:/admin/to/login/page.html";
	}

	@RequestMapping("/admin/do/login.html")
	public String doLogin(
				@RequestParam("loginAcct") String loginAcct,
				@RequestParam("userPswd") String userPswd,
				HttpSession session
			) {
		
		// 调用Service方法执行登录检查
		// 这个方法如果能够返回AdminEntity对象说明登录成功，如果账号、密码不正确则会抛出异常
		AdminEntity adminEntity = adminService.getAdminByLoginAcct(loginAcct, userPswd);
		
		// 将登录成功返回的AdminEntity对象存入Session域
		session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, adminEntity);
		
		return "redirect:/admin/to/main/page.html";
	}

}
