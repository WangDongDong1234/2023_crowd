package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.RoleEntity;
import com.github.pagehelper.PageInfo;

public interface RoleService {
	
	PageInfo<RoleEntity> getPageInfo(Integer pageNum, Integer pageSize, String keyword);

	void saveRole(RoleEntity role);

	void updateRole(RoleEntity role);
	
	void removeRole(List<Integer> roleIdList);
}
