package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.AuthEntity;

import java.util.List;
import java.util.Map;

public interface AuthService {
    List<Integer> getAssignedAuthIdByRoleId(Integer roleId);

    List<AuthEntity> getAll();

    void saveRoleAuthRelathinship(Map<String, List<Integer>> map);

    List<String> selectAssignedAuthNameByAdminId(Integer adminId);
}
