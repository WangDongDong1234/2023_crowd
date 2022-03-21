package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.MenuEntity;

import java.util.List;

public interface MenuService {
    List<MenuEntity> getAll();

    void saveMenu(MenuEntity menu);

    void updateMenu(MenuEntity menu);

    void removeMenu(Integer id);
}
