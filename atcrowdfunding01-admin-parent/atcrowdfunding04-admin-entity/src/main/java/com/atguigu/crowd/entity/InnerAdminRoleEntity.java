package com.atguigu.crowd.entity;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InnerAdminRoleEntity {
    private Integer id;

    private Integer admin_id;

    private Integer role_id;
}