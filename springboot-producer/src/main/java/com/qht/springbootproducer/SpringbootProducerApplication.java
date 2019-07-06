package com.qht.springbootproducer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * SpringBoot-Producer服务
 * @author qht
 * @date 2019/4/25
 * @return
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.qht.springbootproducer.dao")
public class SpringbootProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProducerApplication.class, args);
    }

}
