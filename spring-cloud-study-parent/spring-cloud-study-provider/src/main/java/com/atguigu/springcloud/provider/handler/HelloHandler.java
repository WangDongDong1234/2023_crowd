package com.atguigu.springcloud.provider.handler;

import com.atugui.spring.cloud.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloHandler {

    private Logger logger = LoggerFactory.getLogger(HelloHandler.class);
    
    @GetMapping("/provider/hello")
    public Employee hello(HttpServletRequest request){
        int port = request.getServerPort();
        return new Employee(1,"王冬冬"+port,23.5);
    }

    @GetMapping("/provider/helloFegin")
    public Employee helloFegin(){
        return new Employee(1,"汪如美",23.5);
    }


    @RequestMapping("/provider/get/emp/list/remote")
    public List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword) {

        logger.info("keyword="+keyword);

        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee(33, "empName33", 333.33));
        empList.add(new Employee(44, "empName44", 444.44));
        empList.add(new Employee(55, "empName55", 555.55));

        return empList;
    }


}
