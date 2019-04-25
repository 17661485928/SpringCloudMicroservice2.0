package com.qht.springbootconsumer.api;

import com.qht.springbootconsumer.service.TestConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TestConsumerService testConsumerService;

    @RequestMapping(value = "/queryConsumer")
    public Object queryConsumer(){
        String producerParams = testConsumerService.queryProducer();
        return "SpringBoot-Consumer======>消费者服务"+"####调用####"+producerParams;
    }
}
