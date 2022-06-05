package com.atguigu.springcloud.consumer.handler;

import com.atugui.spring.cloud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/hello")
    public Employee helloRemote(){
        //1.声明远程微服务的主机地址加端口号
        String host = "http://localhost:1000";

        //2.声明具体的耳机口
        String url = "/provider/hello";
        return restTemplate.getForObject(host+url,Employee.class);
    }
}
