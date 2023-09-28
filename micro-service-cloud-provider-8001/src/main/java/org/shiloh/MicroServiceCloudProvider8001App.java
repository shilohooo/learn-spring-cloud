package org.shiloh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 服务提供者启动类
 *
 * {@link EnableEurekaClient} 开启 Eureka 客户端，自动将服务注册到 Eureka Server 注册中心
 *
 * @author shiloh
 * @date 2023/8/17 17:35
 */
@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.shiloh.dao")
public class MicroServiceCloudProvider8001App {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudProvider8001App.class, args);
    }
}
