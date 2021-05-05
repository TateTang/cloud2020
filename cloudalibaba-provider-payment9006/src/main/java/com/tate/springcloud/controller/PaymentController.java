package com.tate.springcloud.controller;

import com.tate.springcloud.entities.CommonResult;
import com.tate.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author tangmf
 * @Date 2021/4/29 9:16 下午
 * @Description
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "sdakjhfjkdashfkjdsahkfhadsjk"));
        hashMap.put(2L, new Payment(2L, "sdakjhfjkdashfkjdsahkfhadsjk"));
        hashMap.put(3L, new Payment(3L, "sdakjhfjkdashfkjdsahkfhadsjk"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200, "from mysql serverPort" + serverPort, payment);
    }
}
