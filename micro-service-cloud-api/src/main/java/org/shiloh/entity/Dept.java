package org.shiloh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.shiloh.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * 部门实体
 *
 * @author shiloh
 * @date 2023/8/17 16:36
 */
@Setter
@Getter
@Entity
@Table(name = "t_dept")
@ToString(callSuper = true)
@org.hibernate.annotations.Table(appliesTo = "t_dept", comment = "部门信息表")
public class Dept extends BaseEntity {
    private static final long serialVersionUID = -1942581273552045764L;

    /**
     * 部门编号
     */
    @Column(name = "dept_no", columnDefinition = "int(11) comment '部门编号'")
    private Integer deptNo;

    /**
     * 部门名称
     */
    @Column(name = "dept_name", columnDefinition = "varchar(255) comment '部门名称'")
    private String deptName;

    /**
     * 数据源
     */
    @Column(name = "db_source", columnDefinition = "varchar(255) comment '数据源'")
    private String dbSource;
}
