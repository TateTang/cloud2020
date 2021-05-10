package com.tate.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author tangmf
 * @Date 2021/5/6 9:12 下午
 * @Description 在应用启动类中关闭SpringBoot的DataSource自动装载
 */
@SpringBootApplication(scanBasePackages = {"com.tate.springcloud"},
        exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class Order2001Main {
    public static void main(String[] args) {
        SpringApplication.run(Order2001Main.class, args);
    }
}
