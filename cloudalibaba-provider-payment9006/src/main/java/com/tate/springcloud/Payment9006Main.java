package com.tate.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author tangmf
 * @Date 2021/4/29 9:14 下午
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9006Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment9006Main.class, args);
    }
}
