package com.example.atcrowdfunding08springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@MapperScans({@MapperScan("com.example.atcrowdfunding08springboot.mapper")})
@ComponentScans({
        @ComponentScan("com.example.atcrowdfunding08springboot.config"),
        @ComponentScan("com.example.atcrowdfunding08springboot.control")})
@SpringBootApplication
public class Atcrowdfunding08SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Atcrowdfunding08SpringbootApplication.class, args);
    }

}
