package com.tate.springcloud.service;

import com.tate.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author tangmf
 * @Date 2021/3/8 8:13 下午
 * @Description
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
