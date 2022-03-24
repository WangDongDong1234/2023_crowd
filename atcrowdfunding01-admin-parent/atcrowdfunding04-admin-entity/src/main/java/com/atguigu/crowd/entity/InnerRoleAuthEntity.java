package com.atguigu.crowd.entity;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InnerRoleAuthEntity {
    private Integer id;

    private Integer role_id;

    private Integer auth_id;
}