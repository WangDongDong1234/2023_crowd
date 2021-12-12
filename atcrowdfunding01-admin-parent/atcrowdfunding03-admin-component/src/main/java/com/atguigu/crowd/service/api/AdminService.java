package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.AdminEntity;

import java.util.List;

public interface AdminService {
	
	void saveAdmin(AdminEntity admin);

	List<AdminEntity> getAll();

}
