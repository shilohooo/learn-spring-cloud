package org.shiloh.entity.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 *
 * @author shiloh
 * @date 2023/8/17 17:21
 */
@Setter
@Getter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1819091402410221355L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "bigint(20) comment '主键'")
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "create_time", columnDefinition = "datetime comment '创建时间'")
    @CreatedDate
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time", columnDefinition = "datetime comment '更新时间'")
    @LastModifiedDate
    private Date updateTime;
}
