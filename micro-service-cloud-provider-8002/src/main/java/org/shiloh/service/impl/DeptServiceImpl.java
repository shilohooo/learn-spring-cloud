package org.shiloh.service.impl;

import lombok.RequiredArgsConstructor;
import org.shiloh.dao.DeptDao;
import org.shiloh.entity.Dept;
import org.shiloh.service.DeptService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 部门 Service Impl
 *
 * @author shiloh
 * @date 2023/8/17 17:29
 */
@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {
    private final DeptDao deptDao;

    /**
     * 根据 ID 获取部门信息
     *
     * @param id 部门 ID
     * @return 部门实体
     * @author shiloh
     * @date 2023/8/17 17:28
     */
    @Override
    public Dept getById(Long id) {
        return this.deptDao.findById(id)
                .orElse(null);
    }

    /**
     * 获取所有部门信息
     *
     * @return 部门实体集合
     * @author shiloh
     * @date 2023/8/17 17:29
     */
    @Override
    public Collection<Dept> getAll() {
        return this.deptDao.findAll(Sort.by(Sort.Direction.DESC, "updateTime"));
    }
}
