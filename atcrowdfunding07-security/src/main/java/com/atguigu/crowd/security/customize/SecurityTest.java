package com.atguigu.crowd.security.customize;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityTest {
    public static void main(String[] args) {
        //1. 创建BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //2. 准备明文字符串
        String rawPassword="123123";
        //3. 加密
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(encodedPassword);

        boolean matches = passwordEncoder.matches(rawPassword, "$2a$10$Y2Cq8ilT21ME.lvu6bwcPO/RMkU7ucAZpmFzx7GDTXK9KNxHyEM1e");
        System.out.println(matches);




    }
}
