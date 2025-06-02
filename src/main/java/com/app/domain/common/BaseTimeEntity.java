package com.app.domain.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass  // 자식클래스의 매핑 정보 제공
@Getter
// (데이터 추적을 위한 추상 클래스 생성 / JPA Audit 기능 이용)
public abstract class BaseTimeEntity {

    // 생성시간
    @CreatedDate
    @Column(updatable = false)  // 생성시간 -> 업데이트 X
    private LocalDateTime createTime;

    // 수정시간
    @LastModifiedDate
    private LocalDateTime updateTime;
}
