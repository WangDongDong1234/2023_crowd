package com.atguigu.crowd.handler;

import com.atguigu.crowd.po.MemberPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.atguigu.crowd.service.api.MemberService;
import util.ResultEntity;


@RestController
public class MemberProviderHandler {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/get/memberpo/by/login/acct/remote")
	public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct) {
		// 1.调用本地Service完成查询
		MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
		if(memberPO!=null){
			return ResultEntity.successWithData(memberPO);
		}else{
			return ResultEntity.failed("未检索到结果");
		}
	}

}
