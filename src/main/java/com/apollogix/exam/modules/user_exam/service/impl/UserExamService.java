package com.apollogix.exam.modules.user_exam.service.impl;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.model.IFilter;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import com.apollogix.exam.modules.common.service.BaseDataService;
import com.apollogix.exam.modules.exam.entity.ExamEntity;
import com.apollogix.exam.modules.exam.service.IExamService;
import com.apollogix.exam.modules.user.entity.UserEntity;
import com.apollogix.exam.modules.user.service.IUserService;
import com.apollogix.exam.modules.user_exam.entity.UserExamEntity;
import com.apollogix.exam.modules.user_exam.model.UserExamDetail;
import com.apollogix.exam.modules.user_exam.model.UserExamInfo;
import com.apollogix.exam.modules.user_exam.service.IUserExamService;
import com.apollogix.exam.util.TimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserExamService extends BaseDataService<UUID, UserExamInfo, UserExamDetail, UserExamEntity> implements IUserExamService {
    private final IExamService iExamService;
    private final IUserService iUserService;

    protected UserExamService(PagingAndSortingRepository<UserExamEntity, UUID> repository, @Qualifier("examService") IExamService iExamService, @Qualifier("userService") IUserService iUserService) {
        super(repository);
        this.iExamService = iExamService;
        this.iUserService = iUserService;
    }

    @Override
    public UserExamEntity createConvertToEntity(UserExamDetail detail) throws InvalidException {
        return UserExamEntity.builder()
                .name(detail.getName())
                .description(detail.getDescription())
                .studentId(detail.getStudentId())
                .examId(detail.getExamId())
                .build();
    }

    @Override
    protected <F extends IFilter> UserExamDetail aroundGetDetail(UUID id, F filter) throws InvalidException {
        return null;
    }

    @Override
    protected <F extends IFilter> BasePagingResponse<UserExamInfo> postGetPage(F filter, Integer number, Integer size) throws InvalidException {
        return null;
    }

    @Override
    protected void postCreate(UserExamEntity entity, UserExamDetail detail) throws InvalidException {
        ExamEntity examEntity = iExamService.getEntity(detail.getExamId());
        UserEntity userEntity = iUserService.getEntity(detail.getStudentId());
        entity.setExam(examEntity);
        entity.setUser(userEntity);
        repository.save(entity);
        super.postCreate(entity, detail);
    }

    @Override
    public void updateConvertToEntity(UserExamEntity entity, UserExamDetail detail) throws InvalidException {
        entity.setCorrect(detail.getCorrect());
        entity.setSubmit(detail.isSubmit());
    }

    @Override
    public UserExamDetail convertToDetail(UserExamEntity entity) throws InvalidException {
        return UserExamDetail.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .studentId(entity.getStudentId())
                .examId(entity.getExamId())
                .examDetail(iExamService.convertToDetail(entity.getExam()))
                .score(entity.getScore())
                .correct(entity.getCorrect())
                .createdDate(TimeUtil.toTimeStamp(entity.getCreatedDate()))
                .lastModifiedDate(TimeUtil.toTimeStamp(entity.getLastModifiedDate()))
                .lastModifiedBy(entity.getLastModifiedBy())
                .createdBy(entity.getCreatedBy())
                .build();
    }

    @Override
    public UserExamInfo convertToInfo(UserExamEntity entity) throws InvalidException {
        return null;
    }
}
