package com.apollogix.exam.modules.exam.model;

import com.apollogix.exam.modules.question.model.QuestionBankDetail;
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
public class ExamDetail extends ExamInfo {
    private List<UUID> questionIds;
    private List<QuestionBankDetail> questionBankDetails;
}
