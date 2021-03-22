package com.tate.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author tangmf
 * @Date 2021/3/21 8:03 下午
 * @Description
 */
@Service
public class PaymentService {

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
        id + "\t" + "耗时(秒)" + timeNumber +"😊";
        //int age = 10 / 0;
        //return "线程池：" + Thread.currentThread().getName() + "paymentinfo_Timeout,id:" +
        //        id + "\t" + "耗时(秒)" + 0;
    }

    //兜底方法
    public String paymentInfo_timeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeOutHandler，8001系统繁忙，" +
                "稍后重试,id:" + id + "\t" + "😭";
    }
}
