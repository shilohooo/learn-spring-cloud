package org.shiloh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 * <p>
 * {@link EnableFeignClients} = 开启 OpenFeign 功能
 *
 * @author shiloh
 * @date 2023/9/28 15:47
 */
@EnableFeignClients
@SpringBootApplication
public class MicroServiceCloudConsumerFeign9001App {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudConsumerFeign9001App.class, args);
    }
}
