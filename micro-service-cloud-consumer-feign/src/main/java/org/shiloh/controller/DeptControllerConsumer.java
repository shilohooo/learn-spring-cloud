package org.shiloh.controller;

import lombok.RequiredArgsConstructor;
import org.shiloh.entity.Dept;
import org.shiloh.service.DeptFeignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * 部门接口消费者
 *
 * @author shiloh
 * @date 2023/9/28 15:49
 */
@RestController
@RequestMapping("/consumer/dept")
@RequiredArgsConstructor
public class DeptControllerConsumer {
    private final DeptFeignService deptFeignService;

    /**
     * 根据 ID 获取部门信息
     *
     * @param id 部门 ID
     * @return 部门实体
     * @author shiloh
     * @date 2023/9/28 15:43
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<Dept> info(@PathVariable("id") Long id) {
        final Dept dept = this.deptFeignService.info(id);
        return ResponseEntity.ok(dept);
    }

    /**
     * 获取所有部门
     *
     * @return 部门列表
     * @author shiloh
     * @date 2023/9/28 15:44
     */
    @GetMapping("/list")
    public ResponseEntity<Collection<Dept>> list() {
        final List<Dept> deptList = this.deptFeignService.list();
        return ResponseEntity.ok(deptList);
    }

    /**
     * 接口超时测试
     *
     * @return 服务端口
     * @author shiloh
     * @date 2023/9/28 16:47
     */
    @GetMapping("/timeout-test")
    public ResponseEntity<Integer> timeoutTest() {
        // OpenFeign 客户端默认等待 1 秒钟，服务端响应超过该时间就会报错
        final int serverPort = this.deptFeignService.timeoutTest();
        return ResponseEntity.ok(serverPort);
    }
}
