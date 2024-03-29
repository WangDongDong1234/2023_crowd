package com.atguigu.crowd.mapper;


import com.atguigu.crowd.po.MemberPO;

import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberPO record);

    int insertSelective(MemberPO record);

    MemberPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberPO record);

    int updateByPrimaryKey(MemberPO record);

    List<MemberPO> selectByloginAcct(String loginAcct);
}