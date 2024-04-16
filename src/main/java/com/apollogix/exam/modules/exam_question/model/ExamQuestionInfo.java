package com.apollogix.exam.modules.exam_question.model;

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
public class ExamQuestionInfo extends BaseModelData<UUID> {
}
