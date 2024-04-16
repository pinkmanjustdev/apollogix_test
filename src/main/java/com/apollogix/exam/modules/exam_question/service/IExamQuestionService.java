package com.apollogix.exam.modules.exam_question.service;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.service.IDataService;
import com.apollogix.exam.modules.exam_question.entity.ExamQuestionEntity;
import com.apollogix.exam.modules.exam_question.model.ExamQuestionDetail;
import com.apollogix.exam.modules.exam_question.model.ExamQuestionInfo;

import java.util.List;
import java.util.UUID;

public interface IExamQuestionService extends IDataService<UUID, ExamQuestionInfo, ExamQuestionDetail> {
    List<ExamQuestionEntity> createExamQuestionEntities(List<UUID> questionIds, UUID examId) throws InvalidException;

}
