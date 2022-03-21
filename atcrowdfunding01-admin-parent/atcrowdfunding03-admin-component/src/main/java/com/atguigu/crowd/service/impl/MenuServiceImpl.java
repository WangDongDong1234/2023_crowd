package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.MenuEntity;
import com.atguigu.crowd.mapper.MenuMapper;
import com.atguigu.crowd.service.api.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<MenuEntity> getAll() {
        return menuMapper.getAll();
    }

    @Override
    public void saveMenu(MenuEntity menu) {
        menuMapper.insert(menu);
    }

    @Override
    public void updateMenu(MenuEntity menu) {

        // 由于pid没有传入，一定要使用有选择的更新，保证“pid”字段不会被置空
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void removeMenu(Integer id) {
        menuMapper.deleteByPrimaryKey(id);
    }
}
