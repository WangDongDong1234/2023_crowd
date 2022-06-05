package com.atguigu.springcloud.provider.handler;

import com.atugui.spring.cloud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHandler {
    
    @GetMapping("/provider/hello")
    public Employee hello(){
        return new Employee(1,"王冬冬",23.5);
    }
}
