package com.tate.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tangmf
 * @Date 2021/4/19 9:14 下午
 * @Description
 */
@RestController
@RefreshScope //支持nacos的动态刷新功能
public class ConfigClientController {
    //配置信息通过接口暴露
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
