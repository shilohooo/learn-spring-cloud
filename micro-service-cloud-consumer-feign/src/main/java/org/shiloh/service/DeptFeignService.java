package org.shiloh.service;

import org.shiloh.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 服务绑定接口，用于远程服务调用
 * <p>
 * 注意：
 * <p>
 * 1. {@link FeignClient#value()} = 服务提供者提供的服务名称（spring.application.name）
 * <p>
 * 2. 接口中定义的每个方法都与服务提供者中 Controller 定义的服务方法对应
 * <p>
 * 3. OpenFeign 客户端默认超时时间为 1 秒
 *
 * @author shiloh
 * @date 2023/9/28 15:41
 */
@Component
@FeignClient(DeptFeignService.SERVICE_PROVIDER_NAME)
public interface DeptFeignService {
    /**
     * 服务提供者提供的服务名称
     */
    String SERVICE_PROVIDER_NAME = "MicroServiceCloudProvider";

    /**
     * 根据 ID 获取部门信息，接口路径对应服务提供者中 Controller 定义的方法
     *
     * @param id 部门 ID
     * @return 部门实体
     * @author shiloh
     * @date 2023/9/28 15:43
     */
    @GetMapping("/dept/info/{id}")
    Dept info(@PathVariable("id") Long id);

    /**
     * 获取所有部门
     *
     * @return 部门列表
     * @author shiloh
     * @date 2023/9/28 15:44
     */
    @GetMapping("/dept/list")
    List<Dept> list();

    /**
     * 超时测试接口
     *
     * @return 服务实例端口
     * @author shiloh
     * @date 2023/9/28 16:50
     */
    @GetMapping("/dept/timeout-test")
    Integer timeoutTest();
}
