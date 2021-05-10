package com.tate.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author tangmf
 * @Date 2021/5/7 6:25 下午
 * @Description
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.tate.springcloud"},
        exclude = DataSourceAutoConfiguration.class)
public class Storage2002Main {
    public static void main(String[] args) {
        SpringApplication.run(Storage2002Main.class, args);
    }
}
