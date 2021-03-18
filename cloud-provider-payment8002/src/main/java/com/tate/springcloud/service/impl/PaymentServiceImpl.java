package com.tate.springcloud.service.impl;

import com.tate.springcloud.dao.PaymentDao;
import com.tate.springcloud.entities.Payment;
import com.tate.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tangmf
 * @Date 2021/3/8 8:14 下午
 * @Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
