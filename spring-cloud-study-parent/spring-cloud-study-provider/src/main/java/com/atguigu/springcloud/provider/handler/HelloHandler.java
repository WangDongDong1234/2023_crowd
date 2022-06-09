package com.atguigu.springcloud.provider.handler;

import com.atugui.spring.cloud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloHandler {
    
    @GetMapping("/provider/hello")
    public Employee hello(HttpServletRequest request){
        int port = request.getServerPort();
        return new Employee(1,"王冬冬"+port,23.5);
    }
}
