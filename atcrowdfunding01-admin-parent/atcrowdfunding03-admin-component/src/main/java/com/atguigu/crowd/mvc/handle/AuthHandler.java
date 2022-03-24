package com.atguigu.crowd.mvc.handle;

import com.atguigu.crowd.entity.AuthEntity;
import com.atguigu.crowd.service.api.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResultEntity;

import java.util.List;
import java.util.Map;

@Controller
public class AuthHandler {
    @Autowired
    private AuthService authService;

    @ResponseBody
    @RequestMapping("/assgin/get/all/auth.json")
    public ResultEntity<List<AuthEntity>> getAllAuth(){
        List<AuthEntity> result =  authService.getAll();
        return ResultEntity.successWithData(result);
    }

    @ResponseBody
    @RequestMapping("/assign/get/assigned/auth/id/by/role/id.json")
    public ResultEntity<List<Integer>> getAssignedAuthIdByRoleId(
            @RequestParam("roleId") Integer roleId) {
        List<Integer> authIdList = authService.getAssignedAuthIdByRoleId(roleId);
        return ResultEntity.successWithData(authIdList);
    }

    @ResponseBody
    @RequestMapping("/assign/do/role/assign/auth.json")
    public ResultEntity<String> saveRoleAuthRelathinship(
            @RequestBody Map<String, List<Integer>> map) {
        authService.saveRoleAuthRelathinship(map);
        return ResultEntity.successWithoutData();
    }
}
