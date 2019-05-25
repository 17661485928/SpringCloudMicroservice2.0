package com.qht.springbootconsumer.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 */
@Controller
public class PageSkippingControllerApi {

    @RequestMapping(value = "/toLoginHtml")
    public Object toLoginHtml(){
        return "login";
    }
}
