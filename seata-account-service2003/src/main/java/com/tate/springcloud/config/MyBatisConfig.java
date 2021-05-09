package com.tate.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author tangmf
 * @Date 2021/5/6 9:46 下午
 * @Description
 */

@Configuration
@MapperScan("com.tate.springcloud.dao")
public class MyBatisConfig {
}
