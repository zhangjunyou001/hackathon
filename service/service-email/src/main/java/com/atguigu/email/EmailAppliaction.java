package com.atguigu.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients //服务发现 Feign
@EnableDiscoveryClient //服务注册 Nacos
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu"})
public class EmailAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(EmailAppliaction.class, args);
    }
}




