package com.tate.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author tangmf
 * @Date 2021/3/8 8:44 下午
 * @Description
 */

@Slf4j
@RestController
public class OrderConsulController {
    private final static String PAYMENT_URL = "http://consul-provider-payment";//payment的名称

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
