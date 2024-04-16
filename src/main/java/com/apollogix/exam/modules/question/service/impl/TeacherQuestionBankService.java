package com.apollogix.exam.modules.question.service.impl;

import com.apollogix.exam.modules.question.entity.QuestionBankEntity;
import com.apollogix.exam.modules.question.service.ITeacherQuestionBankService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TeacherQuestionBankService extends QuestionBankService implements ITeacherQuestionBankService {
    protected TeacherQuestionBankService(PagingAndSortingRepository<QuestionBankEntity, UUID> repository) {
        super(repository);
    }
}
