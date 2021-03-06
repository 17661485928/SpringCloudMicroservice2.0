package com.qht.springbootconsumer.controller;

import com.qht.springbootconsumer.service.TestConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 消费者测试类
 * author:qht
 * Date:2019/4/25
 * Time:17:01
 */
@RestController
@RequestMapping(value = "/consumer/TestConsumerControllerApi")
public class TestConsumerControllerApi {

    @Autowired
    private TestConsumerService testConsumerService;

    @RequestMapping(value = "/queryConsumer")
    public Object queryConsumer(){
        String producerParams = testConsumerService.queryProducer();
        String name = Thread.currentThread().getName();
        System.err.println(name);
        return "SpringBoot-Consumer======>消费者服务"+"####调用####"+producerParams;
    }

    @RequestMapping(value = "/queryConsumer1")
    public Object queryConsumer1(){
        String name = Thread.currentThread().getName();
        System.err.println(name);
        return "queryConsumer1线程池名称====："+name;
    }

    /**
     * 登录接口Api
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public Object login(HttpServletRequest request){
        String jsonParams = request.getParameter("username");
        System.err.println(jsonParams);
        return "login OK!";
    }
}
