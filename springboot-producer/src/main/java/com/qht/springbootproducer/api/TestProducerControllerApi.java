package com.qht.springbootproducer.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 * author:qht
 * Date:2019/4/25
 * Time:16:34
 */
@RestController
@RequestMapping(value = "/producer/TestProducerControllerApi")
public class TestProducerControllerApi {

    @RequestMapping(value = "/queryHelloWorld")
    public Object queryHelloWorld(){
        return "Hello World!";
    }
}