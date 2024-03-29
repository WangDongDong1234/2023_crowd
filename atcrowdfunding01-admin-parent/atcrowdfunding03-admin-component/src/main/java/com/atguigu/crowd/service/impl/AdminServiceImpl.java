package com.atguigu.crowd.service.impl;




import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import constant.CrowdConstant;
import exception.LoginAcctAlreadyInUseException;
import exception.LoginAcctAlreadyInUseForUpdateException;
import exception.LoginFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import util.CrowdUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

	private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void saveAdmin(AdminEntity admin) {


		// 1.密码加密
		String userPswd = admin.getUser_pswd();
		//userPswd = CrowdUtil.md5(userPswd);
		userPswd = bCryptPasswordEncoder.encode(userPswd);
		admin.setUser_pswd(userPswd);

		// 2.生成创建时间
		Date date = new Date();
		admin.setCreate_time(date);

		// 3.执行保存
		try {
			adminMapper.insert(admin);
		} catch (Exception e) {
			e.printStackTrace();

			logger.info("异常全类名="+e.getClass().getName());

			if(e instanceof DuplicateKeyException) {
				throw new LoginAcctAlreadyInUseException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}
		}
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

	@Override
	public AdminEntity getAdminByLoginAcct(String username) {


		List<AdminEntity> list = adminMapper.getAdminByLoginAcct(username);

		AdminEntity admin = list.get(0);

		return admin;
	}

	@Override
	public PageInfo<AdminEntity> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
		// 1.调用PageHelper的静态方法开启分页功能
		// 这里充分体现了PageHelper的“非侵入式”设计：原本要做的查询不必有任何修改
		PageHelper.startPage(pageNum, pageSize);

		// 2.执行查询
		List<AdminEntity> list = adminMapper.selectAdminByKeyword(keyword);

		// 3.封装到PageInfo对象中
		return new PageInfo<>(list);
	}

	@Override
	public void remove(Integer adminId) {
		adminMapper.deleteByPrimaryKey(adminId);
	}

	@Override
	public AdminEntity getAdminById(Integer adminId) {
		return adminMapper.selectByPrimaryKey(adminId);
	}

	@Override
	public void update(AdminEntity admin) {

		// “Selective”表示有选择的更新，对于null值的字段不更新
		try {
			adminMapper.updateByPrimaryKeySelective(admin);
		} catch (Exception e) {
			e.printStackTrace();

			logger.info("异常全类名="+e.getClass().getName());

			if(e instanceof DuplicateKeyException) {
				throw new LoginAcctAlreadyInUseForUpdateException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}
		}
	}
}
