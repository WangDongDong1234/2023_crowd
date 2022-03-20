package com.atguigu.crowd.mvc.handle;

import com.atguigu.crowd.entity.MenuEntity;
import com.atguigu.crowd.service.api.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResultEntity;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuHandler {

    @Resource
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("/menu/get/whole/tree.json")
    public ResultEntity<MenuEntity> getWholeTreeNew() {

        // 1.查询全部的Menu对象
        List<MenuEntity> menuList = menuService.getAll();

        // 2.声明一个变量用来存储找到的根节点
        MenuEntity root = null;

        // 3.创建Map对象用来存储id和Menu对象的对应关系便于查找父节点
        Map<Integer, MenuEntity> menuMap = new HashMap<>();

        // 4.遍历menuList填充menuMap
        for (MenuEntity menu : menuList) {

            Integer id = menu.getId();

            menuMap.put(id, menu);
        }

        // 5.再次遍历menuList查找根节点、组装父子节点
        for (MenuEntity menu : menuList) {

            // 6.获取当前menu对象的pid属性值
            Integer pid = menu.getPid();

            // 7.如果pid为null，判定为根节点
            if(pid == null) {
                root = menu;

                // 8.如果当前节点是根节点，那么肯定没有父节点，不必继续执行
                continue ;
            }

            // 9.如果pid不为null，说明当前节点有父节点，那么可以根据pid到menuMap中查找对应的Menu对象
            MenuEntity father = menuMap.get(pid);

            // 10.将当前节点存入父节点的children集合
            father.getChildren().add(menu);
        }

        // 11.经过上面的运算，根节点包含了整个树形结构，返回根节点就是返回整个树
        return ResultEntity.successWithData(root);
    }

}
