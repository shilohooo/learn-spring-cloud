package org.shiloh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心7002启动类
 * <p>
 * {@link EnableEurekaServer} 开启 Eureka 服务端，接受其他微服务的注册
 *
 * @author shiloh
 * @date 2023/8/17 16:44
 */
@SpringBootApplication
@EnableEurekaServer
public class MicroServiceEurekaServer7002App {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEurekaServer7002App.class, args);
    }
}
