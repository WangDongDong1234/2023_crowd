package com.atguigu.crowd.mapper;


import com.atguigu.crowd.entity.InnerAdminRoleEntity;
import com.atguigu.crowd.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InnerAdminRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InnerAdminRoleEntity record);

    int insertSelective(InnerAdminRoleEntity record);

    InnerAdminRoleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InnerAdminRoleEntity record);

    int updateByPrimaryKey(InnerAdminRoleEntity record);

    List<RoleEntity> selectAssignedRole(Integer adminId);

    List<RoleEntity> selectUnAssignedRole(Integer adminId);

    void deleteOLdRelationship(Integer adminId);

    void insertNewRelationship(@Param("adminId") Integer adminId, @Param("roleIdList") List<Integer> roleIdList);
}