package org.shiloh.app.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * {@link org.springframework.web.client.RestTemplate} 配置
 *
 * @author shiloh
 * @date 2023/8/18 10:23
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 注入 RestTemplate
     * <p>
     * {@link LoadBalanced} 在客户端使用 RestTemplate 请求服务端时，开启负载均衡（Ribbon）
     *
     * @author shiloh
     * @date 2023/8/18 10:25
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // 使用默认配置
        // return new RestTemplate();

        // 可以读取到配置文件中的配置
        return builder.build();
    }
}
