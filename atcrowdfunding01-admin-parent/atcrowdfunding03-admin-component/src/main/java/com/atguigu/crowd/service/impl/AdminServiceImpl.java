package com.atguigu.crowd.service.impl;




import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.github.pagehelper.PageInfo;
import constant.CrowdConstant;
import exception.LoginFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.CrowdUtil;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

	private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public void saveAdmin(AdminEntity admin) {
		
		adminMapper.insert(admin);
	}

	@Override
	public void saveAdminWithRandom(AdminEntity admin){
		int max=100,min=1;
		int value = (int) (Math.random()*(max-min)+min);
		admin.setUser_pswd(Integer.toString(value));
		adminMapper.insert(admin);
		logger.info(String.format("生成的随机数：%s",value));
		if(value%2==0){
			throw new RuntimeException();
		}
	}

	@Override
	public List<AdminEntity> getAll() {
		return adminMapper.selectAll();
	}

	@Override
	public AdminEntity getAdminByLoginAcct(String loginAcct, String userPswd) {

		// 1.根据登录账号查询Admin对象
		List<AdminEntity> list = adminMapper.getAdminByLoginAcct(loginAcct);

		// 2.判断Admin对象是否为null
		if(list == null || list.size() == 0) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}

		if(list.size() > 1) {
			throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
		}

		AdminEntity admin = list.get(0);

		// 3.如果Admin对象为null则抛出异常
		if(admin == null) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}

		// 4.如果Admin对象不为null则将数据库密码从Admin对象中取出
		String userPswdDB = admin.getUser_pswd();

		// 5.将表单提交的明文密码进行加密
		String userPswdForm = CrowdUtil.md5(userPswd);

		// 6.对密码进行比较
		if(!Objects.equals(userPswdDB, userPswdForm)) {
			// 7.如果比较结果是不一致则抛出异常
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}

		// 8.如果一致则返回Admin对象
		return admin;
	}


}
