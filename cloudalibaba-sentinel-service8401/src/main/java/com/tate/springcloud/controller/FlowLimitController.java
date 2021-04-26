package com.tate.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tangmf
 * @Date 2021/4/25 8:56 下午
 * @Description
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "---testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "---testB";
    }
}
