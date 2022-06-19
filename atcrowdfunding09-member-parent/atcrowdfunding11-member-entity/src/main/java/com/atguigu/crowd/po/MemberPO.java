package com.atguigu.crowd.po;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberPO {
    private Integer id;

    private String loginAcct;

    private String userPswd;

    private String userName;

    private String email;

    private Integer authStatus;

    private Integer userType;

    private String realName;

    private String cardNum;

    private Integer acctType;
}