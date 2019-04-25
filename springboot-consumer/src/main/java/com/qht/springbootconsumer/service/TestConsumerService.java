package com.qht.springbootconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "SpringBoot-Producer")
public interface TestConsumerService {

    @RequestMapping("/producer/TestProducerControllerApi/queryProducer")
    public String queryProducer();
}
