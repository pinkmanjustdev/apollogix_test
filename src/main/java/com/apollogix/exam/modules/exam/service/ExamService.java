package com.apollogix.exam.modules.exam.service;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.model.IFilter;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import com.apollogix.exam.modules.common.service.BaseDataService;
import com.apollogix.exam.modules.exam.entity.ExamEntity;
import com.apollogix.exam.modules.exam.model.ExamDetail;
import com.apollogix.exam.modules.exam.model.ExamInfo;
import com.apollogix.exam.modules.exam_question.entity.ExamQuestionEntity;
import com.apollogix.exam.modules.exam_question.service.IExamQuestionService;
import com.apollogix.exam.modules.question.model.QuestionBankDetail;
import com.apollogix.exam.modules.question.service.IQuestionBankService;
import com.apollogix.exam.util.TimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class ExamService extends BaseDataService<UUID, ExamInfo, ExamDetail, ExamEntity> implements IExamService {
    private final IQuestionBankService iQuestionBankService;
    private final IExamQuestionService iExamQuestionService;

    protected ExamService(PagingAndSortingRepository<ExamEntity, UUID> repository, @Qualifier("questionBankService") IQuestionBankService iQuestionBankService, IExamQuestionService iExamQuestionService) {
        super(repository);
        this.iQuestionBankService = iQuestionBankService;
        this.iExamQuestionService = iExamQuestionService;
    }

    @Override
    public ExamEntity createConvertToEntity(ExamDetail detail) throws InvalidException {
        return ExamEntity.builder()
                .timeLimit(detail.getTimeLimit())
                .name(detail.getName())
                .description(detail.getDescription())
//                .questions(detail.getQuestions())
                .build();
    }

    @Override
    protected <F extends IFilter> ExamDetail aroundGetDetail(UUID id, F filter) throws InvalidException {
        return null;
    }

    @Override
    protected <F extends IFilter> BasePagingResponse<ExamInfo> postGetPage(F filter, Integer number, Integer size) throws InvalidException {
        return null;
    }

    @Override
    protected void postCreate(ExamEntity entity, ExamDetail detail) throws InvalidException {
        for (ExamQuestionEntity examQuestion : iExamQuestionService.createExamQuestionEntities(detail.getQuestionIds(), entity.getId())) {
            entity.addExamQuestion(examQuestion);
        }
        repository.save(entity);
        super.postCreate(entity, detail);
    }

    @Override
    public void updateConvertToEntity(ExamEntity entity, ExamDetail detail) throws InvalidException {

    }

    @Override
    public ExamDetail convertToDetail(ExamEntity entity) throws InvalidException {
        return ExamDetail.builder()
                .id(entity.getId())
                .name(entity.getName())
                .timeLimit(entity.getTimeLimit())
                .questionIds(entity.getExamQuestions().stream().map(ExamQuestionEntity::getQuestionId).toList())
                .questionBankDetails(convert(entity.getExamQuestions()))
                .createdDate(TimeUtil.toTimeStamp(entity.getCreatedDate()))
                .lastModifiedDate(TimeUtil.toTimeStamp(entity.getLastModifiedDate()))
                .lastModifiedBy(entity.getLastModifiedBy())
                .createdBy(entity.getCreatedBy())
                .build();
    }

    public List<QuestionBankDetail> convert(Set<ExamQuestionEntity> entities) throws InvalidException {
        List<QuestionBankDetail> questionBankDetails = new ArrayList<>();
        for (ExamQuestionEntity examQuestionEntity : entities) {
            questionBankDetails.add(iQuestionBankService.convertToDetail(
                            iQuestionBankService.getEntity(examQuestionEntity.getQuestionId())
                    )
            );

        }
        return questionBankDetails;
    }

    @Override
    public ExamInfo convertToInfo(ExamEntity entity) throws InvalidException {
        return ExamInfo.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .timeLimit(entity.getTimeLimit())
                .createdDate(TimeUtil.toTimeStamp(entity.getCreatedDate()))
                .lastModifiedDate(TimeUtil.toTimeStamp(entity.getLastModifiedDate()))
                .build();
    }

    @Override
    public ExamEntity getEntity(UUID id) {
        return repository.findById(id).get();
    }
}
