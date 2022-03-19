package com.atguigu.crowd.mapper;


import com.atguigu.crowd.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);

    List<RoleEntity> selectRoleByKeyword(String keyword);

    void removeRole(@Param("roleIdList") List<Integer> roleIdList);
}