package com.apollogix.exam.modules.question.service.impl;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.model.IFilter;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import com.apollogix.exam.modules.common.service.BaseDataService;
import com.apollogix.exam.modules.question.entity.QuestionBankEntity;
import com.apollogix.exam.modules.question.model.QuestionBankDetail;
import com.apollogix.exam.modules.question.model.QuestionBankInfo;
import com.apollogix.exam.modules.question.service.IQuestionBankService;
import com.apollogix.exam.util.TimeUtil;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class QuestionBankService extends BaseDataService<UUID, QuestionBankInfo, QuestionBankDetail, QuestionBankEntity> implements IQuestionBankService {
    protected QuestionBankService(PagingAndSortingRepository<QuestionBankEntity, UUID> repository) {
        super(repository);
    }

    @Override
    protected <F extends IFilter> QuestionBankDetail aroundGetDetail(UUID id, F filter) throws InvalidException {
        return null;
    }

    @Override
    protected <F extends IFilter> BasePagingResponse<QuestionBankInfo> postGetPage(F filter, Integer number, Integer size) throws InvalidException {
        return null;
    }

    @Override
    public QuestionBankEntity createConvertToEntity(QuestionBankDetail detail) throws InvalidException {
        return QuestionBankEntity.builder()
                .questionKey(detail.getQuestionKey())
                .name(detail.getName())
                .description(detail.getDescription())
                .answers(detail.getAnswers())
                .answerChoices(detail.getAnswerChoices())
                .build();
    }

    @Override
    public void updateConvertToEntity(QuestionBankEntity entity, QuestionBankDetail detail) throws InvalidException {

    }

    @Override
    public QuestionBankDetail convertToDetail(QuestionBankEntity entity) throws InvalidException {
        return QuestionBankDetail.builder()
                .id(entity.getId())
                .questionKey(entity.getQuestionKey())
                .name(entity.getName())
                .description(entity.getDescription())
                .answers(entity.getAnswers())
                .answerChoices(entity.getAnswerChoices())
                .createdDate(TimeUtil.toTimeStamp(entity.getCreatedDate()))
                .lastModifiedDate(TimeUtil.toTimeStamp(entity.getLastModifiedDate()))
                .lastModifiedBy(entity.getLastModifiedBy())
                .createdBy(entity.getCreatedBy())
                .build();
    }

    @Override
    public QuestionBankEntity getEntity(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public List<QuestionBankInfo> getQuestionInfos(List<UUID> ids) throws InvalidException {
        List<QuestionBankInfo> questionBankInfos = new ArrayList<>();
        for (QuestionBankEntity questionBankEntity : repository.findAllById(ids)) {
            questionBankInfos.add(convertToInfo(questionBankEntity));
        }
        return questionBankInfos;
    }

    @Override
    public List<QuestionBankDetail> getQuestionDetails(List<UUID> ids) throws InvalidException {
        List<QuestionBankDetail> questionBankDetails = new ArrayList<>();
        for (QuestionBankEntity questionBankEntity : repository.findAllById(ids)) {
            questionBankDetails.add(convertToDetail(questionBankEntity));
        }
        return questionBankDetails;
    }

    @Override
    public QuestionBankInfo convertToInfo(QuestionBankEntity entity) throws InvalidException {
        return QuestionBankInfo.builder()
                .id(entity.getId())
                .questionKey(entity.getQuestionKey())
                .name(entity.getName())
                .description(entity.getDescription())
                .answerChoices(entity.getAnswerChoices())
                .createdDate(TimeUtil.toTimeStamp(entity.getCreatedDate()))
                .lastModifiedDate(TimeUtil.toTimeStamp(entity.getLastModifiedDate()))
                .lastModifiedBy(entity.getLastModifiedBy())
                .createdBy(entity.getCreatedBy())
                .build();
    }
}
