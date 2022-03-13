package com.atguigu.crowd.mapper;


import com.atguigu.crowd.entity.AdminEntity;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminEntity record);

    int insertSelective(AdminEntity record);

    AdminEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminEntity record);

    int updateByPrimaryKey(AdminEntity record);

    List<AdminEntity> selectAll();

    List<AdminEntity> getAdminByLoginAcct(String loginAcct);
}