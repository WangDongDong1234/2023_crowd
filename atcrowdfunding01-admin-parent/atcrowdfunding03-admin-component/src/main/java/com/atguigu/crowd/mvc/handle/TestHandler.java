package com.atguigu.crowd.mvc.handle;


import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestHandler {
	
	@Autowired
	private AdminService adminService;

	/**
	 * http://localhost:8080/atcrowdfunding02_admin_webui_war/index.jsp
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/test/ssm.html")
	public String test1(ModelMap modelMap) {
		
		List<AdminEntity> adminList = adminService.getAll();
		
		modelMap.addAttribute("adminList", adminList);

		return "target";
	}

}
