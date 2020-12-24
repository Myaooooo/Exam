package com.myao.exam.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    //使用数据库获取的用户来认证
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    //数据库查询用户
                    .usersByUsernameQuery("select username,password,enabled from user WHERE username=?")
                    //数据库查询用户权限
                    .authoritiesByUsernameQuery("select username,authority from authorities where username=?")
                    .passwordEncoder(new BCryptPasswordEncoder());
        }
//                    // <X> 使用内存中的 InMemoryUserDetailsManager
//                    .inMemoryAuthentication()
//                    // <Y> 不使用 PasswordEncoder 密码编码器
//                    .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                    // <Z> 配置 admin 用户
//                    .withUser("admin").password("admin").roles("ADMIN")
//                    // <Z> 配置 normal 用户
//                    .and().withUser("normal").password("normal").roles("NORMAL");
 //       }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    // <M> 配置请求地址的权限
                    .authorizeRequests()
                    // 所有用户可访问
                    .antMatchers("/test/echo").permitAll()
                    // 需要 ADMIN 角色
                    .antMatchers("/test/admin").hasRole("ADMIN")
                    // 需要 NORMAL 角色
                    .antMatchers("/test/normal").access("hasRole('ROLE_NORMAL')")
                    // 任何请求，访问的用户都需要经过认证
                    .anyRequest().authenticated()
                    .and()
                    // <N> 设置 Form 表单登陆
                    .formLogin().loginPage("/login")
                    // 登陆 URL 地址 所有用户可访问
                    //.loginPage("/login")
                    .permitAll()
                    .and()
                    // 配置退出相关
                    .logout()
                    //退出 URL 地址 所有用户可访问
                    //.logoutUrl("/logout")
                    .permitAll();
        }
    }

