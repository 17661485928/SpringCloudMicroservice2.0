package com.qht.springbootconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.qht.springbootconsumer.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/UserLoginController")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public Object userLogin(HttpServletRequest request){
        Map<String,Object> requestMap = new HashMap<>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        requestMap.put("user_name",username);
        requestMap.put("pass_word",password);
        String requestParams = JSONObject.toJSONString(requestMap);
        String resString = userLoginService.userLogin(requestParams);
        List<Map<String,Object>> resMap = (List<Map<String, Object>>) JSONObject.parse(resString);
        if(0>=resMap.size()){
            return "loginError";
        }
        return "loginSuccess";
    }
}
