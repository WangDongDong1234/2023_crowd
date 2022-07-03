package com.atguigu.crowd.handler;

import com.atguigu.crowd.po.MemberPO;
import constant.CrowdConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.atguigu.crowd.service.api.MemberService;
import util.ResultEntity;


@RestController
public class MemberProviderHandler {

	Logger logger = LoggerFactory.getLogger(MemberProviderHandler.class);
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("/save/member/remote")
	public ResultEntity<String> saveMember(
			@RequestBody MemberPO memberPO) {

		logger.info(memberPO.toString());

		try {

			memberService.saveMember(memberPO);

			return ResultEntity.successWithoutData();

		}catch(Exception e) {

			if(e instanceof DuplicateKeyException) {
				return ResultEntity.failed(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}

			return ResultEntity.failed(e.getMessage());
		}

	}
	
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
