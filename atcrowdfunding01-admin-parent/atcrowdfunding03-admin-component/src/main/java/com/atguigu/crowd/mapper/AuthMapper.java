package com.atguigu.crowd.mapper;


import com.atguigu.crowd.entity.AuthEntity;

import java.util.List;

public interface AuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthEntity record);

    int insertSelective(AuthEntity record);

    AuthEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthEntity record);

    int updateByPrimaryKey(AuthEntity record);

    List<AuthEntity> getAll();
}