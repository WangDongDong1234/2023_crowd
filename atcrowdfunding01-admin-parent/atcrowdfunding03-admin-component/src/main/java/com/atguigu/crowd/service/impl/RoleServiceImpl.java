package com.atguigu.crowd.service.impl;

import java.util.List;

import com.atguigu.crowd.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public PageInfo<RoleEntity> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
		
		// 1.开启分页功能
		PageHelper.startPage(pageNum, pageSize);
		
		// 2.执行查询
		List<RoleEntity> roleList = roleMapper.selectRoleByKeyword(keyword);
		
		// 3.封装为PageInfo对象返回
		return new PageInfo<>(roleList);
	}

	@Override
	public void saveRole(RoleEntity role) {
		roleMapper.insertSelective(role);
	}

	@Override
	public void updateRole(RoleEntity role) {
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public void removeRole(List<Integer> roleIdList) {
		roleMapper.removeRole(roleIdList);
	}

}
