package com.tate.springcloud.service;

import com.tate.springcloud.entities.CommonResult;
import com.tate.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author tangmf
 * @Date 2021/3/18 8:16 下午
 * @Description
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//服务消费者 进行使用
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
