package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.RoleEntity;

import java.util.List;

public interface AssignService {
    /**
     * 查询已分配角色
     * @param adminId
     * @return
     */
    List<RoleEntity> getAssignedRole(Integer adminId);

    /**
     * 查询未分配角色
     * @param adminId
     * @return
     */
    List<RoleEntity> getUnAssignedRole(Integer adminId);

    void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);
}
