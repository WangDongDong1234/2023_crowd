package com.atguigu.crowd.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 父节点的id
     */
    private Integer pid;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点附带的URL地址，是将来点击菜单项时要跳转的地址
     */
    private String url;

    /**
     * 节点图标的样式
     */
    private String icon;

    /**
     * 存储子节点的集合，初始化是为了避免空指针异常
     */
    private List<MenuEntity> children = new ArrayList<MenuEntity>();

    /**
     * 控制节点是否默认为打开装，设置为true表示默认打开
     */
    private Boolean open = true;
}