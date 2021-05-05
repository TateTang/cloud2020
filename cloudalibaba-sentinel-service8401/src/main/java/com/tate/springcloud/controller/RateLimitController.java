package com.tate.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tate.springcloud.entities.CommonResult;
import com.tate.springcloud.entities.Payment;
import com.tate.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tangmf
 * @Date 2021/4/29 8:21 下午
 * @Description
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult<>(200, "资源名称限流测试ok", new Payment(2020L, "serial2021"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult<>(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult<>(200, "URL地址限流测试ok", new Payment(2020L, "serial2021"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult<>(200, "客户自定义限流测试ok", new Payment(2020L, "serial2021"));
    }
}
