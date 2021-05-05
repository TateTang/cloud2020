package com.tate.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tate.springcloud.entities.CommonResult;
import com.tate.springcloud.entities.Payment;
import com.tate.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author tangmf
 * @Date 2021/4/29 9:29 下午
 * @Description 解决服务熔断功能
 */
@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${server-url.nacos-user-service}")
    private String serverUrl;
    @Resource
    private RestTemplate restTemplate;
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")//没有配置，没有熔断和降级
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")//只配置了fallback,处理业务异常
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")//blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler"
            , exceptionsToIgnore = {IllegalArgumentException.class})//都配置，忽略某个异常
    public CommonResult<Payment> fallback(@PathVariable("id") long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serverUrl + "/paymentSQL/" + id,
                CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException ，空指针异常");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "兜底业务异常"
                + e.getMessage(), payment);
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") long id, BlockException blockException) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(445, "block-sentinel限流"
                + blockException.getMessage(), payment);
    }

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
