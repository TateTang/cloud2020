package com.tate.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tate.springcloud.entities.CommonResult;

/**
 * @Author tangmf
 * @Date 2021/4/29 8:45 下午
 * @Description 自定义限流处理类
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult<>(4444, "客户自定义Global BlockException");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult<>(4444, "客户自定义Global BlockException 222");
    }
}
