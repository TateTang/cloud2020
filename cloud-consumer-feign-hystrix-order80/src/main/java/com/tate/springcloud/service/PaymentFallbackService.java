package com.tate.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String payment_ok(Integer id) {
        return "PaymentHystrixService payment_ok fallback 😭";
    }

    @Override
    public String paymentInfo_timeOut(Integer id) {
        return "PaymentHystrixService paymentInfo_timeOut fallback 😭";
    }
}
