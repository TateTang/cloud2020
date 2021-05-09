package com.tate.springcloud.service;

import java.math.BigDecimal;

/**
 * @Author tangmf
 * @Date 2021/5/7 8:11 下午
 * @Description
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
