package com.atguigu.crowd.mvc.handle;


import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.entity.ParamData;
import com.atguigu.crowd.entity.Student;
import com.atguigu.crowd.service.api.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import util.CrowdUtil;
import util.ResultEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestHandler {
	
	@Autowired
	private AdminService adminService;

	private Logger logger = LoggerFactory.getLogger(TestHandler.class);


	/**
	 * http://localhost:8080/atcrowdfunding02_admin_webui_war/index.jsp
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/test/ssm.html")
	public String test1_2(ModelMap modelMap) {
		
		List<AdminEntity> adminList = adminService.getAll();
		
		modelMap.addAttribute("adminList", adminList);

		return "target";
	}


	@ResponseBody
	@RequestMapping("/send/array/one.html")
	public String test3(@RequestParam("array[]") List<Integer> array) {

		for (Integer number : array) {
			System.out.println("number="+number);
		}

		return "success";
	}


	@ResponseBody
	@RequestMapping("/send/array/two.html")
	public String test4(ParamData paramData) {

		List<Integer> array = paramData.getArray();

		for (Integer number : array) {
			System.out.println("number="+number);
		}

		return "success";
	}

	@ResponseBody
	@RequestMapping("/send/array/three.html")
	public String test5(@RequestBody List<Integer> array) {

		for (Integer number : array) {
			logger.info("number="+number);
		}

		return "success";
	}

	@ResponseBody
	@RequestMapping("/send/compose/object1.json")
	public String test6(@RequestBody Student student) {


		logger.info(student.toString());
		return "success";
	}

	@ResponseBody
	@RequestMapping("/send/compose/object2.json")
	public ResultEntity<Student> test7(@RequestBody Student student, HttpServletRequest request) {

		boolean judgeResult = CrowdUtil.judgeRequestType(request);

		logger.info("judgeResult="+judgeResult);

		logger.info(student.toString());

		// 将“查询”到的Student对象封装到ResultEntity中返回
		ResultEntity<Student> resultEntity = ResultEntity.successWithData(student);

//		String a = null;
//
//		System.out.println(a.length());

		return resultEntity;
	}
}
