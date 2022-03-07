package com.atguigu.crowd.service.impl;




import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

	private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminMapper adminMapper;

	public void saveAdmin(AdminEntity admin) {
		
		adminMapper.insert(admin);
	}

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

	public List<AdminEntity> getAll() {
		return adminMapper.selectAll();
	}

}
