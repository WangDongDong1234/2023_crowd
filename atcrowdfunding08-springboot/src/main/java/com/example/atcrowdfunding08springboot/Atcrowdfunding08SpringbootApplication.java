package com.example.atcrowdfunding08springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScans({@MapperScan("com.example.atcrowdfunding08springboot.mapper")})
@SpringBootApplication
public class Atcrowdfunding08SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Atcrowdfunding08SpringbootApplication.class, args);
    }

}
