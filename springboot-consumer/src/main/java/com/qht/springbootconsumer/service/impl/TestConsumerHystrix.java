package com.qht.springbootconsumer.service.impl;

import com.qht.springbootconsumer.service.TestConsumerService;
import org.springframework.stereotype.Component;

/**
 * 熔断
 * author:qht
 * Date:2019/4/30
 * Time:10:58
 */
@Component
public class TestConsumerHystrix implements TestConsumerService {
    @Override
    public String queryProducer() {

        return "hello queryProducer, this messge send failed ";
    }
}
