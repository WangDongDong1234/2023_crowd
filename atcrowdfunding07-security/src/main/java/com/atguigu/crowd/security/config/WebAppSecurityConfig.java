package com.atguigu.crowd.security.config;

import com.atguigu.crowd.security.customize.MyPasswordEncoder;
import com.atguigu.crowd.security.service.impl.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        //super.configure(auth); 一定要禁用默认规则
//        builder.inMemoryAuthentication()
//                .withUser("putong").password("putong") //设置账号密码
//                .roles("普通") //设置角色
//                .and()
//                .withUser("gaoji").password("gaoji")//设置另一个账号密码
//                .authorities("高级") //设置权限
//                .and()
//                .withUser("jueshi").password("jueshi")
//                .roles("绝世")
//                ;
        builder.userDetailsService(userDetailService).passwordEncoder(myPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        security
                .authorizeRequests()			// 对请求进行授权
                .antMatchers("/index.jsp")		// 针对/index.jsp路径进行授权
                .permitAll()					// 可以无条件访问
                .antMatchers("/layui/**")		// 针对/layui目录下所有资源进行授权
                .permitAll()
                .antMatchers("/level1/**")		// 针对/level1/**路径设置访问要求
                .hasRole("普通")					// 要求用户具备“学徒”角色才可以访问
                .antMatchers("/level2/**")		// 针对/level2/**路径设置访问要求
                .hasAuthority("高级")
                .antMatchers("/level3/**")		// 针对/level1/**路径设置访问要求
                .hasRole("绝世")	// 可以无条件访问
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
                .defaultSuccessUrl("/main.html") //设置登录成功后默认前往的 URL 地址
                .and()
//                .csrf()
//                .disable()                       //禁用csrf功能
                .logout()
                .logoutUrl("/do/logout.html")    //指定推出界面
                .and()
                .exceptionHandling()                 //指定异常处理器
//                .accessDeniedPage("/to/no/auth/page.html")  //访问被拒绝的处理页面（方式1）
                .accessDeniedHandler(new AccessDeniedHandler() {  //访问被拒绝的处理页面（方式2）
                    @Override
                    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                        httpServletRequest.setAttribute("message", e.getMessage()+"####");
                        httpServletRequest.getRequestDispatcher("/WEB-INF/views/no_auth.jsp").forward(httpServletRequest, httpServletResponse);

                    }
                }).and()
                .rememberMe()            //开启记住我功能，记住我的参数必须是remember-me，如果记住我的功能的name不是checkbox，则可以用rememberMeParameter()方法指定参数名
                .tokenRepository(repository);
        ;
    }


}
