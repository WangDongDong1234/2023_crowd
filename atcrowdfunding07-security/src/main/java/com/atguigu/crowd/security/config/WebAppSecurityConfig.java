package com.atguigu.crowd.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        //super.configure(auth); 一定要禁用默认规则
        builder.inMemoryAuthentication()
                .withUser("tom").password("123123") //设置账号密码
                .roles("ADMIN") //设置角色
                .and()
                .withUser("jerry").password("456456")//设置另一个账号密码
                .authorities("SAVE","EDIT"); //设置权限
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                .authorizeRequests()			// 对请求进行授权
                .antMatchers("/index.jsp")		// 针对/index.jsp路径进行授权
                .permitAll()					// 可以无条件访问
                .antMatchers("/layui/**")		// 针对/layui目录下所有资源进行授权
                .permitAll()					// 可以无条件访问
                .and()
                .authorizeRequests()			// 对请求进行授权
                .anyRequest()					// 任意请求
                .authenticated()				// 需要登录以后才可以访问
                .and()
                .formLogin()					// 使用表单形式登录

                // 关于loginPage()方法的特殊说明
                // 指定登录页的同时会影响到：“提交登录表单的地址”、“退出登录地址”、“登录失败地址”
                // /index.jsp GET - the login form 去登录页面
                // /index.jsp POST - process the credentials and if valid authenticate the user 提交登录表单
                // /index.jsp?error GET - redirect here for failed authentication attempts 登录失败
                // /index.jsp?logout GET - redirect here after successfully logging out 退出登录
                .loginPage("/index.jsp")		// 指定登录页面（如果没有指定会访问SpringSecurity自带的登录页）

                // loginProcessingUrl()方法指定了登录地址，就会覆盖loginPage()方法中设置的默认值/index.jsp POST
                .loginProcessingUrl("/do/login.html") 	// 指定提交登录表单的地址
                .usernameParameter("loginAcct") // 定制登录账号的请求参数名，要去前端页面检查，如用标签中设置的属性不正确，请求报302
                .passwordParameter("userPswd") // 定制登录密码的请求参数名，要去前端页面检查，如用标签中设置的属性不正确，请求报302
                .defaultSuccessUrl("/main.html"); //设置登录成功后默认前往的 URL 地址
        ;
    }
}
