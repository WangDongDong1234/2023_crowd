package com.atguigu.crowd.mapper;


import com.atguigu.crowd.entity.InnerRoleAuthEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InnerRoleAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InnerRoleAuthEntity record);

    int insertSelective(InnerRoleAuthEntity record);

    InnerRoleAuthEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InnerRoleAuthEntity record);

    int updateByPrimaryKey(InnerRoleAuthEntity record);

    List<Integer> selectAssignedAuthIdByRoleId(Integer roleId);

    void deleteOldRelationship(Integer roleId);

    void insertNewRelationship(@Param("roleId") Integer roleId, @Param("authIdList") List<Integer> authIdList);
}