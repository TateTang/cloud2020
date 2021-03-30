package com.tate.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author tangmf
 * @Date 2021/3/29 9:41 下午
 * @Description
 */
@Configuration
public class GateWayConfig {
    /**
     * 配置了一个id为route-name的路由规则，
     * 访问地址localhost:9527/guonei 自动转发到https://news.baidu.com/guonei
     */
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_tate1",
                r -> r.path("/guonei")
                        .uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
