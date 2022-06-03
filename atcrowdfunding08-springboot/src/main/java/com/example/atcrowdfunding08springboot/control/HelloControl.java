package com.example.atcrowdfunding08springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControl {

    @ResponseBody
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "hello world!";
    }
}
