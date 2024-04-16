package com.apollogix.exam.modules.question.model;

import com.apollogix.exam.modules.common.model.BaseModelData;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class QuestionBankInfo extends BaseModelData<UUID> {
    private String questionKey;
    private List<AnswerInfo> answerChoices;
}
