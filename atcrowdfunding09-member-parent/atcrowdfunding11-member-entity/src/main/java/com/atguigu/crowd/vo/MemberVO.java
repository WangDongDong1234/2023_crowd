package com.atguigu.crowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	
	private String loginAcct;
	
	private String userPswd;

    private String userName;
	
	private String email;
	
	private String phoneNum;
	
	private String code;

}
