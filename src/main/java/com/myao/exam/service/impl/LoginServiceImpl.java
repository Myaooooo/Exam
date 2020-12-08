package com.myao.exam.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myao.exam.entity.User;
import com.myao.exam.mapper.LoginMapper;
import com.myao.exam.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {

}
