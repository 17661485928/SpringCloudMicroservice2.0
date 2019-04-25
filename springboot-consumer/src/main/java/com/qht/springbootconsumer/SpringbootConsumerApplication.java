package com.qht.springbootconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * SpringBoot-Consumer消费者服务
 * @author qht
 * @date 2019/4/25
 * @return
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringbootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConsumerApplication.class, args);
    }

}
