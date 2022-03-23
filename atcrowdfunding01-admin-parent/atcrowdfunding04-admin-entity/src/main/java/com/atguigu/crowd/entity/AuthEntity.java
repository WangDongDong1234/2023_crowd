package com.atguigu.crowd.entity;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthEntity {
    private Integer id;

    private String name;

    private String title;

    private Integer category_id;
}