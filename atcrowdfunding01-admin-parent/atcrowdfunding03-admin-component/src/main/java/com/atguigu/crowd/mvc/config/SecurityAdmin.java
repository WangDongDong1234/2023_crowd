package com.atguigu.crowd.mvc.config;

import java.util.List;

import com.atguigu.crowd.entity.AdminEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/**
 * 考虑到User对象中仅仅包含账号和密码，为了能够获取到原始的Admin对象，专门创建这个类对User类进行扩展
 * @author Lenovo
 *
 */
public class SecurityAdmin extends User {
	
	private static final long serialVersionUID = 1L;
	
	// 原始的Admin对象，包含Admin对象的全部属性
	private AdminEntity originalAdmin;
	
	public SecurityAdmin(
			// 传入原始的Admin对象
			AdminEntity originalAdmin,
			
			// 创建角色、权限信息的集合
			List<GrantedAuthority> authorities) {
		
		// 调用父类构造器
		super(originalAdmin.getLogin_acct(), originalAdmin.getUser_pswd(), authorities);
		
		// 给本类的this.originalAdmin赋值
		this.originalAdmin = originalAdmin;
		
	}
	
	// 对外提供的获取原始Admin对象的getXxx()方法
	public AdminEntity getOriginalAdmin() {
		return originalAdmin;
	}

}
