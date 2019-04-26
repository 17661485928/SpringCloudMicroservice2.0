package com.qht.springbootproducer.api;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${qht}")
    private String qht;
    @RequestMapping(value = "/queryProducer")
    public Object queryProducer(){
        return "SpringBoot-Producer==========>生产者服务"+qht;
    }
}
