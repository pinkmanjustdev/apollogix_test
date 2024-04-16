package com.apollogix.exam.modules.exam.service;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.service.IDataService;
import com.apollogix.exam.modules.exam.entity.ExamEntity;
import com.apollogix.exam.modules.exam.model.ExamDetail;
import com.apollogix.exam.modules.exam.model.ExamInfo;

import java.util.UUID;

public interface IExamService extends IDataService<UUID, ExamInfo, ExamDetail> {
    ExamDetail convertToDetail(ExamEntity entity) throws InvalidException;

    ExamEntity getEntity(UUID id);
}
