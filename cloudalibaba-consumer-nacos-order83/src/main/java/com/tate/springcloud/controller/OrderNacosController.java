package com.tate.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author tangmf
 * @Date 2021/4/19 8:32 下午
 * @Description
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id,
                String.class);
    }
}
