package com.atguigu.crowd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrowdWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器访问的地址
        String urlPath = "/auth/member/to/reg/page";

        // 目标视图的名称，将来拼接“prefix: classpath:/templates/”、“suffix: .html”前后缀
        String viewName = "member/member-reg";

        // 添加view-controller
        // 1 会员注册页面（填写个人信息）
        registry.addViewController(urlPath).setViewName(viewName);
        // 2 会员登录页面
        registry.addViewController("/auth/member/to/login/page").setViewName("member/member-login");
        // 3 登录成功界面
        registry.addViewController("/auth/member/to/center/page").setViewName("member/member-center");
    }
}
