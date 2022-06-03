package com.example.atcrowdfunding08springboot.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 当前类存放读取yml配置文件的数据，要求当前类也在IOC容器中
@Component

// @ConfigurationProperties表示和yml配置文件对应，读取其中数据
// prefix属性表示和yml配置文件中以“student”开头的配置项对应
@ConfigurationProperties(prefix = "student")
public class Student {
	
	private Integer stuId;
	private String stuName;
	private Boolean graduated;
	private String[] subject;
	private Date birthday;
	// 如果不使用@DateTimeFormat指定日期时间格式，那么必须使用默认格式“1990/10/12”
	// 如果不使用默认格式就必须使用@DateTimeFormat注解的pattern指定日期时间格式
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date weddingDay;
	private Map<String, String> teachers;
	private Address address;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endDateTime;
}
