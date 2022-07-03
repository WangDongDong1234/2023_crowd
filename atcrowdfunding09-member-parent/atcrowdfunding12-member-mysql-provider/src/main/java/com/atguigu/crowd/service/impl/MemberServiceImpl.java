package com.atguigu.crowd.service.impl;



import com.atguigu.crowd.mapper.MemberMapper;
import com.atguigu.crowd.po.MemberPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.atguigu.crowd.service.api.MemberService;
import org.springframework.util.CollectionUtils;

import java.util.List;

// 在类上使用@Transactional(readOnly = true)针对查询操作设置事务属性
@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public MemberPO getMemberPOByLoginAcct(String loginAcct) {
		List<MemberPO> list = memberMapper.selectByloginAcct(loginAcct);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}else{
			return list.get(0);
		}
	}


	@Transactional(
			propagation = Propagation.REQUIRES_NEW,
			rollbackFor = Exception.class,
			readOnly = false)
	@Override
	public void saveMember(MemberPO memberPO) {
		memberMapper.insertSelective(memberPO);
	}

}
