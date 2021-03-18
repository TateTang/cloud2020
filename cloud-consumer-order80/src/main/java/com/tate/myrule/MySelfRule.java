package com.tate.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author tangmf
 * @Date 2021/3/15 7:56 下午
 * @Description 自定义负载均衡规则类
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //默认轮询
        return new RandomRule();//定义为随机

    }
}
