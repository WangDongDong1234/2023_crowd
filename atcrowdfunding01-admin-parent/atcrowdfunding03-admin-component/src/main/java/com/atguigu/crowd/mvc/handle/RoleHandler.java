package com.atguigu.crowd.mvc.handle;

import java.util.Collection;
import java.util.List;

import com.atguigu.crowd.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.service.api.RoleService;
import com.github.pagehelper.PageInfo;
import util.ResultEntity;

@Controller
public class RoleHandler {
	
	@Autowired
	private RoleService roleService;

	@PreAuthorize("hasAuthority('role:delete')")
	@ResponseBody
	@RequestMapping("/role/remove/by/role/id/array.json")
	public ResultEntity<String> removeByRoleIdAarry(@RequestBody List<Integer> roleIdList) {
		if(!roleIdList.isEmpty()){
			roleService.removeRole(roleIdList);
		}
		return ResultEntity.successWithoutData();
	}

	@PreAuthorize("hasAuthority('role:update')")
	@ResponseBody
	@RequestMapping("/role/update.json")
	public ResultEntity<String> updateRole(RoleEntity role) {
		
		roleService.updateRole(role);
		
		return ResultEntity.successWithoutData();
	}

	@PreAuthorize("hasAuthority('role:add')")
	@ResponseBody
	@RequestMapping("/role/save.json")
	public ResultEntity<String> saveRole(RoleEntity role) {
		
		roleService.saveRole(role);
		
		return ResultEntity.successWithoutData();
	}

	/**
	 * 需要具备管理员(super)角色才能访问这个接口
	 * @param pageNum
	 * @param pageSize
	 * @param keyword
	 * @return
	 */

	@PreAuthorize("hasRole('管理员(super)')")
	@ResponseBody
	@RequestMapping("/role/get/page/info.json")
	public ResultEntity<PageInfo<RoleEntity>> getPageInfo(
				@RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
				@RequestParam(value="pageSize", defaultValue="5") Integer pageSize,
				@RequestParam(value="keyword", defaultValue="") String keyword
			) {
		
		// 调用Service方法获取分页数据
		PageInfo<RoleEntity> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);
		
		// 封装到ResultEntity对象中返回（如果上面的操作抛出异常，交给异常映射机制处理）
		return ResultEntity.successWithData(pageInfo);
	}

}
