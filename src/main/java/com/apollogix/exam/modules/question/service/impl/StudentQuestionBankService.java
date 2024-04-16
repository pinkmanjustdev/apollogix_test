package com.apollogix.exam.modules.question.service.impl;

import com.apollogix.exam.modules.question.entity.QuestionBankEntity;
import com.apollogix.exam.modules.question.service.IStudentQuestionBankService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StudentQuestionBankService extends QuestionBankService implements IStudentQuestionBankService {
    protected StudentQuestionBankService(PagingAndSortingRepository<QuestionBankEntity, UUID> repository) {
        super(repository);
    }
}
