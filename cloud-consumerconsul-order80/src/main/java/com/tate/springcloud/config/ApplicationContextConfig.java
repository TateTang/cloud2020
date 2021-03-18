package com.tate.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author tangmf
 * @Date 2021/3/8 8:48 下午
 * @Description 配置类
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced//开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
