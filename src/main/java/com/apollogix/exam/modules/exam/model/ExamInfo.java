package com.apollogix.exam.modules.exam.model;

import com.apollogix.exam.modules.common.model.BaseModelData;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class ExamInfo extends BaseModelData<UUID> {
    private Integer timeLimit;
}
