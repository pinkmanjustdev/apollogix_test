package com.apollogix.exam.modules.exam_question.service;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.model.IFilter;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import com.apollogix.exam.modules.common.service.BaseDataService;
import com.apollogix.exam.modules.exam_question.entity.ExamQuestionEntity;
import com.apollogix.exam.modules.exam_question.model.ExamQuestionDetail;
import com.apollogix.exam.modules.exam_question.model.ExamQuestionInfo;
import com.apollogix.exam.modules.question.service.IQuestionBankService;
import com.apollogix.exam.util.TimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ExamQuestionService extends BaseDataService<UUID, ExamQuestionInfo, ExamQuestionDetail, ExamQuestionEntity> implements IExamQuestionService {

    private final IQuestionBankService iQuestionBankService;

    protected ExamQuestionService(PagingAndSortingRepository<ExamQuestionEntity, UUID> repository, @Qualifier("questionBankService") IQuestionBankService iQuestionBankService) {
        super(repository);
        this.iQuestionBankService = iQuestionBankService;
    }

    @Override
    public ExamQuestionEntity createConvertToEntity(ExamQuestionDetail detail) throws InvalidException {
        return ExamQuestionEntity.builder()
                .questionId(detail.getQuestionId())
                .name(detail.getName())
                .description(detail.getDescription())
                .build();
    }

    @Override
    public void updateConvertToEntity(ExamQuestionEntity entity, ExamQuestionDetail detail) throws InvalidException {

    }

    @Override
    public ExamQuestionDetail convertToDetail(ExamQuestionEntity entity) throws InvalidException {
        return ExamQuestionDetail.builder()
                .examId(entity.getExamId())
                .questionId(entity.getQuestionId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdDate(TimeUtil.toTimeStamp(entity.getCreatedDate()))
                .lastModifiedDate(TimeUtil.toTimeStamp(entity.getLastModifiedDate()))
                .lastModifiedBy(entity.getLastModifiedBy())
                .createdBy(entity.getCreatedBy())
                .build();
    }

    @Override
    protected <F extends IFilter> ExamQuestionDetail aroundGetDetail(UUID id, F filter) throws InvalidException {
        return null;
    }

    @Override
    protected <F extends IFilter> BasePagingResponse<ExamQuestionInfo> postGetPage(F filter, Integer number, Integer size) throws InvalidException {
        return null;
    }

    @Override
    protected void postGetDetail(ExamQuestionEntity entity, ExamQuestionDetail detail) throws InvalidException {

        super.postGetDetail(entity, detail);
    }

    @Override
    public ExamQuestionInfo convertToInfo(ExamQuestionEntity entity) throws InvalidException {
        return null;
    }

    @Override
    public List<ExamQuestionEntity> createExamQuestionEntities(List<UUID> questionIds, UUID examId) throws InvalidException {
        List<ExamQuestionEntity> entities = new ArrayList<>();
        for (UUID id : questionIds) {
            ExamQuestionEntity entity = repository.save(ExamQuestionEntity.builder()
                    .name("")
                    .description("")
                    .questionId(id)
                    .examId(examId)
                    .build());
            entities.add(entity);
        }
        return entities;
    }
}
