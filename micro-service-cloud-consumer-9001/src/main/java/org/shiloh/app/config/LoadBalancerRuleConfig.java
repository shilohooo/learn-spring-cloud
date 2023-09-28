package org.shiloh.app.config;

import com.netflix.loadbalancer.IRule;
import org.shiloh.loadbalancer.rule.MyRandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 负载均衡策略配置
 *
 * @author shiloh
 * @date 2023/9/28 14:27
 */
@Configuration
public class LoadBalancerRuleConfig {
    /**
     * 使用随机的负载均衡策略
     *
     * @author shiloh
     * @date 2023/9/28 14:28
     */
    @Bean
    public IRule myRule() {
        // return new RandomRule();
        // 使用自定义的负载均衡策略
        return new MyRandomRule();
    }
}
