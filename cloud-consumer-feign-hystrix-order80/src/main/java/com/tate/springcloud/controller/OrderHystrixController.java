package com.tate.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tate.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tangmf
 * @Date 2021/3/22 8:17 下午
 * @Description
 */
@RequestMapping("/consumer")
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String getPaymentById(@PathVariable("id") Integer id) {
        return paymentHystrixService.payment_ok(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    //3秒钟返回正常，否则兜底方法
    //@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    //})
    @HystrixCommand//这里直接调用全局的
    public String paymentFeignTimeout(@PathVariable("id") Integer id) {
        //int age = 10/0;//服务异常
        return paymentHystrixService.paymentInfo_timeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁请10秒钟后再试或者自己运行出错请检査自己,o(r_r)o";
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理，请稍后重试，😭";
    }

}
