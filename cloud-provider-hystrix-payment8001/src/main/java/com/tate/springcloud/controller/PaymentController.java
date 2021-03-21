package com.tate.springcloud.controller;

import com.tate.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tangmf
 * @Date 2021/3/21 8:09 下午
 * @Description
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {
        String result = paymentService.payment_ok(id);
        log.info("****result" + result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_timeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_timeOut(id);
        log.info("****result" + result);
        return result;
    }
}
