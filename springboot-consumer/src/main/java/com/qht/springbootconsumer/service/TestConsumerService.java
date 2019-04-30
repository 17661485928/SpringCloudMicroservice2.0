package com.qht.springbootconsumer.service;

import com.qht.springbootconsumer.service.impl.TestConsumerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "SpringBoot-Producer",fallback = TestConsumerHystrix.class)
public interface TestConsumerService {

    @RequestMapping("/producer/TestProducerControllerApi/queryProducer")
    public String queryProducer();
}
