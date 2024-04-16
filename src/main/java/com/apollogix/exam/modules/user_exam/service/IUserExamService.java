package com.apollogix.exam.modules.user_exam.service;

import com.apollogix.exam.modules.common.service.IDataService;
import com.apollogix.exam.modules.user_exam.model.UserExamDetail;
import com.apollogix.exam.modules.user_exam.model.UserExamInfo;

import java.util.UUID;

public interface IUserExamService extends IDataService<UUID, UserExamInfo, UserExamDetail> {
}
