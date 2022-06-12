package com.atguigu.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 启用Feign客户端功能
@EnableFeignClients
@SpringBootApplication
public class FeginConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeginConsumerApplication.class,args);
    }
}
