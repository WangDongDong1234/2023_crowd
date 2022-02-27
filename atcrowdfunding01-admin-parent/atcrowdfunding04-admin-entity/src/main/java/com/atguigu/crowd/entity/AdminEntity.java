package com.atguigu.crowd.entity;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {
    private Integer id;

    private String login_acct;

    private String user_pswd;

    private String user_name;

    private String email;

    private Date create_time;

}