package tate.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author tangmf
 * @Date 2021/3/8 8:34 下午
 * @Description
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoradMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoradMain9001.class, args);
    }
}
