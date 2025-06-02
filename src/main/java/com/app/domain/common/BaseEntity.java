package com.app.domain.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
// (데이터 추적을 위한 추상 클래스 생성 / JPA Audit 기능 이용)
public abstract class BaseEntity extends BaseTimeEntity {

    // 생성자
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    // 수정자
    @LastModifiedBy
    private String modifiedBy;

}
