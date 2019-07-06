package com.qht.springbootconsumer.service;

import com.qht.springbootconsumer.service.impl.UserLoginServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "SpringBoot-Producer",fallback = UserLoginServiceHystrix.class)
public interface UserLoginService {

    @PostMapping("/UserLoginApi/findUserInformationList")
    public String  userLogin(String requestJson);
}
