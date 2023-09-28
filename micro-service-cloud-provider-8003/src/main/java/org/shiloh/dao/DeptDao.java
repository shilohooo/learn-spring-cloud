package org.shiloh.dao;

import org.shiloh.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 部门 DAO
 *
 * @author shiloh
 * @date 2023/8/17 17:27
 */
@Repository
public interface DeptDao extends JpaRepository<Dept, Long>, JpaSpecificationExecutor<Dept> {
}
