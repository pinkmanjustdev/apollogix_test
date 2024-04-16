package com.apollogix.exam.modules.user_exam.service.impl;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.exam.model.ExamDetail;
import com.apollogix.exam.modules.exam.service.IExamService;
import com.apollogix.exam.modules.question.model.AnswerInfo;
import com.apollogix.exam.modules.question.model.QuestionBankDetail;
import com.apollogix.exam.modules.question.service.IQuestionBankService;
import com.apollogix.exam.modules.user.service.IUserService;
import com.apollogix.exam.modules.user_exam.entity.UserExamEntity;
import com.apollogix.exam.modules.user_exam.model.UserExamDetail;
import com.apollogix.exam.modules.user_exam.model.request.SubmitExamRequest;
import com.apollogix.exam.modules.user_exam.service.IStudentUserExamService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class StudentUserExamService extends UserExamService implements IStudentUserExamService {
    private final IQuestionBankService iQuestionBankService;
    private final IExamService iExamService;

    protected StudentUserExamService(PagingAndSortingRepository<UserExamEntity, UUID> repository, @Qualifier("examService") IExamService iExamService, @Qualifier("userService") IUserService iUserService, @Qualifier("questionBankService") IQuestionBankService iQuestionBankService, @Qualifier("studentExamService") IExamService iExamService1) {
        super(repository, iExamService, iUserService);
        this.iQuestionBankService = iQuestionBankService;
        this.iExamService = iExamService1;
    }

    @Override
    public UserExamDetail submitExam(SubmitExamRequest request, UUID userExamId) throws InvalidException {
        UserExamDetail detail = getDetailModel(userExamId);
        ExamDetail examDetail = iExamService.getDetailModel(detail.getExamId());
        List<QuestionBankDetail> questionBankDetails = iQuestionBankService.getQuestionDetails(examDetail.getQuestionIds());
        int correct = 0;
        for (QuestionBankDetail questionBankDetail : questionBankDetails) {
            List<String> actualAnswers = request.getQuestionAnswer().get(questionBankDetail.getId());
            List<String> givenAnswers = new ArrayList<>(questionBankDetail.getAnswers().stream().map(AnswerInfo::getContent).toList());
            Collections.sort(actualAnswers);
            Collections.sort(givenAnswers);
            if (actualAnswers.equals(givenAnswers)) correct++;
        }

        return updateModel(detail.getId(), detail.toBuilder()
                .isSubmit(true)
                .correct(correct)
                .build()
        );
    }

    @Override
    public UserExamDetail getQuestion(UUID id) throws InvalidException {
        UserExamDetail detail = getDetailModel(id);
        ExamDetail examDetail = iExamService.getDetailModel(detail.getExamId());
        return detail.toBuilder()
                .examQuestionsAndChoices(iQuestionBankService.getQuestionInfos(examDetail.getQuestionIds()))
                .build();
    }
}
