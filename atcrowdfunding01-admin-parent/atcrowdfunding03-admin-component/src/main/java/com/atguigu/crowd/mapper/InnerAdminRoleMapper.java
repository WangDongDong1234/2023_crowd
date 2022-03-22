package com.atguigu.crowd.mapper;


import com.atguigu.crowd.entity.InnerAdminRoleEntity;

public interface InnerAdminRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InnerAdminRoleEntity record);

    int insertSelective(InnerAdminRoleEntity record);

    InnerAdminRoleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InnerAdminRoleEntity record);

    int updateByPrimaryKey(InnerAdminRoleEntity record);
}