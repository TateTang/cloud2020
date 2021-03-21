package com.tate.springcloud.service;

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


    public String paymentInfo_timeOut(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentinfo_Timeout,id:" +
                id + "\t" + "耗时(秒)" + timeNumber;
    }
}
