package com.qht.springbootconsumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 */
@Controller
public class PageSkippingController {
    @RequestMapping(value = "/")
    public Object toLoginHtml(){
        return "login";
    }

    @RequestMapping(value = "/toLoginError")
    public Object toLoginError(){
        return "loginError";
    }
}
