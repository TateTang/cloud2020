package com.tate.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author tangmf
 * @Date 2021/3/21 8:03 下午
 * @Description
 */
@Service
public class PaymentService {
    //=====================服务降级=====================

    /**
     * 正常访问
     *
     * @param id
     */
    public String payment_ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "payment_ok，id" + id + "\t" + "😊";
    }


    //3秒钟返回正常，否则兜底方法
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_timeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentinfo_Timeout,id:" +
                id + "\t" + "耗时(秒)" + timeNumber + "😊";
        //int age = 10 / 0;
        //return "线程池：" + Thread.currentThread().getName() + "paymentinfo_Timeout,id:" +
        //        id + "\t" + "耗时(秒)" + 0;
    }

    //兜底方法
    public String paymentInfo_timeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeOutHandler，8001系统繁忙，" +
                "稍后重试,id:" + id + "\t" + "😭";
    }

    //=====================服务熔断=====================

    /**
     * 在10秒窗口期中10次请求有6次是请求失败的,断路器将起作用
     */
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
    }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能是负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数,请稍后重试,o(╥﹏╥)o id:" + id;
    }
}
