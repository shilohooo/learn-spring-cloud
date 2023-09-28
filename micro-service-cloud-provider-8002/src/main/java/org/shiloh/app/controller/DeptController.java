package org.shiloh.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shiloh.entity.Dept;
import org.shiloh.service.DeptService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * 部门接口
 *
 * @author shiloh
 * @date 2023/8/17 17:31
 */
@Slf4j
@RestController
@RequestMapping("/dept")
@RequiredArgsConstructor
public class DeptController {
    private final DeptService deptService;

    @Value("${server.port}")
    private Integer serverPort;

    /**
     * * 根据 ID 获取部门信息
     *
     * @param id 部门 ID
     * @return 部门实体
     * @author shiloh
     * @date 2023/8/17 17:32
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<Dept> info(@PathVariable("id") Long id) {
        final Dept dept = this.deptService.getById(id);
        return ResponseEntity.ok(dept);
    }

    /**
     * 获取所有部门信息
     *
     * @return 部门实体集合
     * @author shiloh
     * @date 2023/8/17 17:32
     */
    @GetMapping("/list")
    public ResponseEntity<Collection<Dept>> list() {
        final Collection<Dept> deptList = this.deptService.getAll();
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
        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            log.error("thread interrupt error", e);
            Thread.currentThread().interrupt();
        }

        return ResponseEntity.ok(this.serverPort);
    }
}
