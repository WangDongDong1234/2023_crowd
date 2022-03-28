package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.AuthEntity;
import com.atguigu.crowd.mapper.AuthMapper;
import com.atguigu.crowd.mapper.InnerRoleAuthMapper;
import com.atguigu.crowd.service.api.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;
    @Autowired
    private InnerRoleAuthMapper innerRoleAuthMapper;
    @Override
    public List<Integer> getAssignedAuthIdByRoleId(Integer roleId) {
        return innerRoleAuthMapper.selectAssignedAuthIdByRoleId(roleId);
    }

    @Override
    public List<AuthEntity> getAll() {
        return authMapper.getAll();
    }

    @Override
    public void saveRoleAuthRelathinship(Map<String, List<Integer>> map) {
        // 1.获取 roleId 的值
        List<Integer> roleIdList = map.get("roleId");
        Integer roleId = roleIdList.get(0);
        // 2.删除旧关联关系数据
        innerRoleAuthMapper.deleteOldRelationship(roleId);
        // 3.获取 authIdList
        List<Integer> authIdList = map.get("authIdArray");
        // 4.判断 authIdList 是否有效
        if(authIdList != null && authIdList.size() > 0) {
            innerRoleAuthMapper.insertNewRelationship(roleId, authIdList);
        }
    }

    @Override
    public List<String> selectAssignedAuthNameByAdminId(Integer adminId) {
        return innerRoleAuthMapper.selectAssignedAuthNameByAdminId(adminId);
    }
}
