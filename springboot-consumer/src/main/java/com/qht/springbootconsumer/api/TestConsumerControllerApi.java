package com.qht.springbootconsumer.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者测试类
 * author:qht
 * Date:2019/4/25
 * Time:17:01
 */
@RestController
@RequestMapping(value = "/consumer/TestConsumerControllerApi")
public class TestConsumerControllerApi {

    @RequestMapping(value = "/queryConsumer")
    public Object queryConsumer(){
        return "SpringBoot-Consumer======>消费者服务";
    }
}
