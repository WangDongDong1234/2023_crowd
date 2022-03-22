package com.atguigu.crowd.mapper;


import com.atguigu.crowd.entity.AdminEntity;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 存在索引问题，后面用elasticsearch
     * @param keyword
     * @return
     */
    List<AdminEntity> selectAdminByKeyword(String keyword);
}