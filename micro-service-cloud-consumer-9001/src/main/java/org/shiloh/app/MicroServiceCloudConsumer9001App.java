package org.shiloh.app;

import org.shiloh.app.config.LoadBalancerRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 服务消费者启动类
 * 自定义 Ribbon 负载均衡策略：
 * <p>
 * 在主启动类上使用 RibbonClient 注解，在该微服务启动时，就能自动去加载我们自定义的 Ribbon 配置类，从而使配置生效
 * <p>
 * {@link RibbonClient#name()} = 需要定制负载均衡策略的微服务名称（application name）
 * <p>
 * {@link RibbonClient#configuration()} = 为定制的负载均衡策略的配置类，且官方文档中明确提出，
 * <p>
 * 该配置类不能在 ComponentScan 注解（SpringBootApplication 注解中包含了该注解）下的包或其子包中，
 * <p>
 * 即自定义负载均衡配置类不能在 org.shiloh.app 包及其子包下
 *
 * @author shiloh
 * @date 2023/8/18 10:24
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MicroServiceCloudProvider", configuration = LoadBalancerRuleConfig.class)
public class MicroServiceCloudConsumer9001App {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudConsumer9001App.class, args);
    }
}
