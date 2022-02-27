package com.atguigu.crowd.entity;



import lombok.*;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private Integer stuId;
	private String stuName;
	private Address address;
	private List<Subject> subjectList;
	private Map<String, String> map;
}
