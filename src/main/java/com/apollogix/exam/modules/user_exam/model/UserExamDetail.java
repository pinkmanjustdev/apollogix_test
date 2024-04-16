package com.apollogix.exam.modules.user_exam.model;

import com.apollogix.exam.modules.exam.model.ExamDetail;
import com.apollogix.exam.modules.question.model.QuestionBankInfo;
import com.apollogix.exam.modules.user.model.UserDetail;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class UserExamDetail extends UserExamInfo {
    private ExamDetail examDetail;
    private UserDetail userDetail;
    private List<QuestionBankInfo> examQuestionsAndChoices;
    private boolean isSubmit;
}
