package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.po.MemberPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.ResultEntity;


@RestController
public class MemberConsumerHandler {
	
	@Autowired
	private MySQLRemoteService mySQLRemoteService;
	
	@RequestMapping("/get/memberpo/by/login/acct")
	public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct) {
		return mySQLRemoteService.getMemberPOByLoginAcctRemote(loginacct);
	}

}
