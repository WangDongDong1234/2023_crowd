package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.AdminEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
	
	void saveAdmin(AdminEntity admin);

	List<AdminEntity> getAll();

	void saveAdminWithRandom(AdminEntity admin);

	AdminEntity getAdminByLoginAcct(String loginAcct, String userPswd);

	PageInfo<AdminEntity> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

	void remove(Integer adminId);

	AdminEntity getAdminById(Integer adminId);

	void update(AdminEntity admin);
}
