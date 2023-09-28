package org.shiloh.service;

import org.shiloh.entity.Dept;

import java.util.Collection;

/**
 * 部门 Service
 *
 * @author shiloh
 * @date 2023/8/17 17:28
 */
public interface DeptService {
    /**
     * 根据 ID 获取部门信息
     *
     * @param id 部门 ID
     * @return 部门实体
     * @author shiloh
     * @date 2023/8/17 17:28
     */
    Dept getById(Long id);

    /**
     * 获取所有部门信息
     *
     * @return 部门实体集合
     * @author shiloh
     * @date 2023/8/17 17:29
     */
    Collection<Dept> getAll();
}
