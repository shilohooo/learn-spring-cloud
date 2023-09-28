package org.shiloh.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenFeign 配置
 *
 * @author shiloh
 * @date 2023/9/28 17:03
 */
@Configuration
public class FeignConfig {

    /**
     * OpenFeign 日志增量：配置 OpenFeign 记录哪些内容
     *
     * @author shiloh
     * @date 2023/9/28 17:04
     */
    @Bean
    public Logger.Level loggerLevel() {
        // 记录所有请求与响应的明细，包括头信息、请求体、元数据等等
        return Logger.Level.FULL;
    }
}
