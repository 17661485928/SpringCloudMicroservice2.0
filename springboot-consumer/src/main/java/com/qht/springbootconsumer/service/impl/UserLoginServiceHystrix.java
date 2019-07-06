package com.qht.springbootconsumer.service.impl;

import com.qht.springbootconsumer.service.UserLoginService;
import org.springframework.stereotype.Component;

@Component
public class UserLoginServiceHystrix implements UserLoginService {

    @Override
    public String userLogin(String requestJson) {
        return "登录繁忙，请稍等！";
    }
}
