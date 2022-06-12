//要求包在消费者的扫描目录下
package com.atguigu.springcloud.consumer.api;

import com.atugui.spring.cloud.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


// @FeignClient注解表示当前接口和一个Provider对应，注解中value属性指定要调用的Provider的微服务名称
@FeignClient(value = "atguigu-provider")
public interface EmployeeRemoteService {

    // 远程调用的接口方法
    // 要求@RequestMapping注解映射的地址一致
    // 要求方法声明一致
    // 用来获取请求参数的@RequestParam、@PathVariable、@RequestBody不能省略，两边一致
    @GetMapping("/provider/helloFegin")
    public Employee helloFegin();


    @RequestMapping("/provider/get/emp/list/remote")
    public List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword);


}
