package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.RoleEntity;

import java.util.List;

public interface AssignService {
    List<RoleEntity> getAssignedRole(Integer adminId);

    List<RoleEntity> getUnAssignedRole(Integer adminId);

    void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);
}
