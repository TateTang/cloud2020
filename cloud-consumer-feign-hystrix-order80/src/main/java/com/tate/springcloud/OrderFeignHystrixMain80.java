package com.tate.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author tangmf
 * @Date 2021/3/18 8:12 下午
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient //服务注册中心
@EnableFeignClients //启用feign客户端
@EnableHystrix
public class OrderFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain80.class, args);
    }
}
