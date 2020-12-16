package com.myao.exam.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();

        registry
          // 表单登录方式
        .and().formLogin().permitAll()
        .and().logout().permitAll()
         //任何请求需要身份认证
        .and().authorizeRequests().anyRequest().authenticated()
        // 关闭跨站请求防护 前后端分离采用JWT 不需要session
        .and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}
}
