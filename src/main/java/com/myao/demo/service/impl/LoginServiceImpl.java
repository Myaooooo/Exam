package com.myao.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myao.demo.entity.User;
import com.myao.demo.mapper.LoginMapper;
import com.myao.demo.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {

}
