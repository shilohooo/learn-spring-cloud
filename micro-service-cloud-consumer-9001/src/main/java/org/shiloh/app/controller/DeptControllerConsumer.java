package org.shiloh.app.controller;

import lombok.RequiredArgsConstructor;
import org.shiloh.entity.Dept;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 部门接口消费者
 *
 * @author shiloh
 * @date 2023/8/18 10:27
 */
@RestController
@RequestMapping("/consumer/dept")
@RequiredArgsConstructor
public class DeptControllerConsumer {
    /**
     * 服务提供者地址前缀，这种是直接调用服务方的接口，没有使用到 SpringCloud
     */
    // private static final String SERVICE_PROVIDER_URL_PREFIX = "http://localhost:8001";

    /**
     * 通过微服务名称来获取服务提供者的地址，使用注册到 SpringCloud Eureka 服务注册中心的服务，即 spring.application.name
     */
    private static final String SERVICE_PROVIDER_URL_PREFIX = "http://MicroServiceCloudProvider";

    private final RestTemplate restTemplate;

    /**
     * 根据 id 获取部门信息
     *
     * @param id 部门 id
     * @return 部门信息
     * @author shiloh
     * @date 2023/8/18 11:10
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<Dept> info(@PathVariable("id") Long id) {
        final ParameterizedTypeReference<Dept> typeReference = new ParameterizedTypeReference<Dept>() {
        };
        final String url = String.format("%s/dept/info/%d", SERVICE_PROVIDER_URL_PREFIX, id);
        return this.restTemplate.exchange(url, HttpMethod.GET, null, typeReference);
    }

    /**
     * 获取部门列表
     *
     * @return 部门列表
     * @author shiloh
     * @date 2023/8/18 11:20
     */
    @GetMapping("/list")
    public ResponseEntity<List<Dept>> list() {
        final ParameterizedTypeReference<List<Dept>> typeReference = new ParameterizedTypeReference<List<Dept>>() {
        };
        final String url = String.format("%s/dept/list", SERVICE_PROVIDER_URL_PREFIX);
        return this.restTemplate.exchange(url, HttpMethod.GET, null, typeReference);
    }
}
