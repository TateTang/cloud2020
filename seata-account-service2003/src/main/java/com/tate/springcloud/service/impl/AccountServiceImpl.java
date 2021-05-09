package com.tate.springcloud.service.impl;

import com.tate.springcloud.dao.AccountDao;
import com.tate.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author tangmf
 * @Date 2021/5/7 8:12 下午
 * @Description
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("********->account-service中扣减账户余额开始");
        ////模拟超时异常
        //try {
        //    TimeUnit.SECONDS.sleep(20);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        accountDao.decrease(userId, money);
        log.info("********->account-service中扣减账户余额结束");
    }
}
