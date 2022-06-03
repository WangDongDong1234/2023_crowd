package com.example.atcrowdfunding08springboot.mapper;


import com.example.atcrowdfunding08springboot.entity.AdminEntity;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminEntity record);

    int insertSelective(AdminEntity record);

    AdminEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminEntity record);

    int updateByPrimaryKey(AdminEntity record);
}