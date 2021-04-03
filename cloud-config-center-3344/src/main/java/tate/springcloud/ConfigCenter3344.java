package tate.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author tangmf
 * @Date 2021/4/3 4:05 下午
 * @Description
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344.class, args);
    }
}
