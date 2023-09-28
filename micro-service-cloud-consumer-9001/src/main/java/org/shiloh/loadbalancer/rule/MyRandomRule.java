package org.shiloh.loadbalancer.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 自定义负载均衡策略
 *
 * @author shiloh
 * @date 2023/9/28 14:34
 */
@Slf4j
public class MyRandomRule extends AbstractLoadBalancerRule {
    /**
     * 总共被调用的次数，目前要求每台被调用5次
     */
    private Integer total = 0;

    /**
     * 当前提供服务的机器号
     */
    private Integer currentIndex = 0;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        // empty impl
    }

    /**
     * 选择要调用的服务实例
     *
     * @param key key
     * @return 服务实例
     * @author shiloh
     * @date 2023/9/28 14:50
     */
    @Override
    public Server choose(Object key) {
        log.info("load balancer - key is {}", key);
        return this.choose(getLoadBalancer(), key);
    }

    /**
     * 选择要调用的服务实例
     *
     * @param loadBalancer 负载均衡器
     * @param key          key
     * @return 服务实例
     * @author shiloh
     * @date 2023/9/28 14:50
     */
    public Server choose(ILoadBalancer loadBalancer, Object key) {
        if (loadBalancer == null) {
            return null;
        }

        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            // 获取所有有效的服务实例
            final List<Server> reachableServers = loadBalancer.getReachableServers();
            // 获取所有服务实例
            final List<Server> allServers = loadBalancer.getAllServers();
            // 如果没有任何的服务实例则返回 null
            if (CollectionUtils.isEmpty(allServers)) {
                return null;
            }
            // 与随机策略相似，但每个服务实例只有在调用3次之后，才会调用其他的服务实例
            if (this.total < 3) {
                server = reachableServers.get(this.currentIndex);
                this.total++;
            } else {
                this.total = 0;
                this.currentIndex++;
                if (this.currentIndex >= reachableServers.size()) {
                    this.currentIndex = 0;
                }
            }
            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return server;
            }
            server = null;
            Thread.yield();
        }

        return server;
    }
}
