package com.tate.springcloud.service;

import com.tate.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author tangmf
 * @Date 2021/5/6 9:19 下午
 * @Description
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping(value = "account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money);
}
