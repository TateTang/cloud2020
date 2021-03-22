package com.tate.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author tangmf
 * @Date 2021/3/22 8:17 下午
 * @Description
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-SERVICE")
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    String payment_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_timeOut(@PathVariable("id") Integer id);
}
