package com.tate.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author tangmf
 * @Date 2021/3/21 8:02 下午
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }

    /*学比置是为了服务盤控定置,与服各容本身モ关,
        springcloud升级后的坑
        Servletregistrationbean/メ为
        springbok的认路经小是"/ hystrix. stream 平只要在已的项目聖配置上下面 servlet就可以了
    */
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getservlet() {
        HystrixMetricsStreamServlet streamservlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationbean = new ServletRegistrationBean<>(streamservlet);
        registrationbean.setLoadOnStartup(1);
        registrationbean.addUrlMappings("/hystrix.stream");
        registrationbean.setName("HystrixMetricsStreamServlet");
        return registrationbean;
    }
}
