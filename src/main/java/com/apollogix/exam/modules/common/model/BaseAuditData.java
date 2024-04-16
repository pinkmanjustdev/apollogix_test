package com.apollogix.exam.modules.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseAuditData<T extends Serializable> extends BaseData<T> {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long createdDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID createdBy;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID lastModifiedBy;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long lastModifiedDate;

    /**
     * @param <T> T extends Serializable
     * @param <C> C extends BaseAuditData
     * @param <B> B extends BaseAuditData.BaseAuditDataBuilder
     */
    public abstract static class BaseAuditDataBuilder<
            T extends Serializable,
            C extends BaseAuditData<T>,
            B extends BaseAuditData.BaseAuditDataBuilder<T, C, B>
            >
            extends BaseData.BaseDataBuilder<T, C, B> {
    }
}