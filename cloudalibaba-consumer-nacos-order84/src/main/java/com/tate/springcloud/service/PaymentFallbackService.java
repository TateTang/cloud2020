package com.tate.springcloud.service;

import com.tate.springcloud.entities.CommonResult;
import com.tate.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @Author tangmf
 * @Date 2021/5/5 7:03 下午
 * @Description
 */
@Service
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回，---PaymentFallbackService",
                new Payment(id, "errorSerial"));
    }
}
