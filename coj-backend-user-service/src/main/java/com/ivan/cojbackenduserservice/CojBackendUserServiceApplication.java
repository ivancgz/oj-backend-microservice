package com.ivan.cojbackenduserservice;

import org.mybatis.spring.annotation .MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ivan.cojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.ivan")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.ivan.cojbackendserviceclient.service")
public class CojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CojBackendUserServiceApplication.class, args);
    }

}
