package com.apollogix.exam.modules.question.service;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.service.IDataService;
import com.apollogix.exam.modules.question.entity.QuestionBankEntity;
import com.apollogix.exam.modules.question.model.QuestionBankDetail;
import com.apollogix.exam.modules.question.model.QuestionBankInfo;

import java.util.List;
import java.util.UUID;

public interface IQuestionBankService extends IDataService<UUID, QuestionBankInfo, QuestionBankDetail> {
    QuestionBankDetail convertToDetail(QuestionBankEntity entity) throws InvalidException;

    QuestionBankEntity getEntity(UUID id);

    List<QuestionBankInfo> getQuestionInfos(List<UUID> ids) throws InvalidException;

    List<QuestionBankDetail> getQuestionDetails(List<UUID> ids) throws InvalidException;
}
