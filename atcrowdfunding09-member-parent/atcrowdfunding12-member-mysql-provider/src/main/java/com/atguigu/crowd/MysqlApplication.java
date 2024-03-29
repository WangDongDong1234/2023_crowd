package com.atguigu.crowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 扫描MyBatis的Mapper接口所在的包
@MapperScan("com.atguigu.crowd.mapper")
@SpringBootApplication
public class MysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class,args);
    }
}
