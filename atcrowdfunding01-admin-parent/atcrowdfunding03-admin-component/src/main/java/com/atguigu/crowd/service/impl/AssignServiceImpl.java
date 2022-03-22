package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.RoleEntity;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.mapper.InnerAdminRoleMapper;
import com.atguigu.crowd.service.api.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssignServiceImpl implements AssignService {

    @Autowired
    private InnerAdminRoleMapper innerAdminRoleMapper;

    @Override
    public List<RoleEntity> getAssignedRole(Integer adminId) {
        return innerAdminRoleMapper.selectAssignedRole(adminId);
    }

    @Override
    public List<RoleEntity> getUnAssignedRole(Integer adminId) {
        return innerAdminRoleMapper.selectUnAssignedRole(adminId);
    }

    @Override
    public void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList) {
        // 旧数据如下：
        // adminId roleId
        // 1 1（要删除）
        // 1 2（要删除）
        // 1 3
        // 1 4
        // 1 5
        // 新数据如下：
        // adminId roleId
        // 1 3（本来就有）
        // 1 4（本来就有）
        // 1 5（本来就有）
        // 1 6（新）
        // 1 7（新）
        // 为了简化操作：先根据 adminId 删除旧的数据，再根据 roleIdList 保存全部新的数据
        // 1.根据 adminId 删除旧的关联关系数据
        innerAdminRoleMapper.deleteOLdRelationship(adminId);
        // 2.根据 roleIdList 和 adminId 保存新的关联关系
        if(roleIdList != null && roleIdList.size() > 0) {
            innerAdminRoleMapper.insertNewRelationship(adminId, roleIdList);
        }
    }
}
