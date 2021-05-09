package com.tate.springcloud.service;

import com.tate.springcloud.domain.Order;

/**
 * @Author tangmf
 * @Date 2021/5/6 9:18 下午
 * @Description
 */
public interface OrderService {
    void create(Order order);
}
