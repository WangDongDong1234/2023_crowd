package com.atguigu.crowd.mvc.handle;

import com.atguigu.crowd.entity.RoleEntity;
import com.atguigu.crowd.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AssignHandler {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/assign/to/assign/role/page.html")
    public String toAssignRolePage(
            @RequestParam("adminId") Integer adminId, ModelMap modelMap
    ) {
        // 1.查询已分配角色
        List<RoleEntity> assignedRoleList = roleService.getAssignedRole(adminId);
        // 2.查询未分配角色
        List<RoleEntity> unAssignedRoleList = roleService.getUnAssignedRole(adminId);
        // 3.存入模型（本质上其实是：request.setAttribute("attrName",attrValue);
        modelMap.addAttribute("assignedRoleList", assignedRoleList);
        modelMap.addAttribute("unAssignedRoleList", unAssignedRoleList);
        return "assign/assign-role";
    }

}
