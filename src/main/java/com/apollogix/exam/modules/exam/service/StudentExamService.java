package com.apollogix.exam.modules.exam.service;

import com.apollogix.exam.modules.exam.entity.ExamEntity;
import com.apollogix.exam.modules.exam_question.service.IExamQuestionService;
import com.apollogix.exam.modules.question.service.IQuestionBankService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StudentExamService extends ExamService implements IStudentExamService {
    protected StudentExamService(PagingAndSortingRepository<ExamEntity, UUID> repository, @Qualifier("questionBankService") IQuestionBankService iQuestionBankService, IExamQuestionService iExamQuestionService) {
        super(repository, iQuestionBankService, iExamQuestionService);
    }
}
