package com.apollogix.exam.modules.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Audit
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit implements Serializable {

    @CreatedBy
    @Column(updatable = false)
    @JsonIgnore
    private UUID createdBy;

    @CreatedDate
    @Column(updatable = false)
    @JsonIgnore
    @Builder.Default
    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedBy
    @JsonIgnore
    private UUID lastModifiedBy;

    @LastModifiedDate
    @JsonIgnore
    @Builder.Default
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

}
