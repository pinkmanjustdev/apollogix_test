package com.apollogix.exam.modules.user_exam.service;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.user_exam.model.UserExamDetail;
import com.apollogix.exam.modules.user_exam.model.request.SubmitExamRequest;

import java.util.UUID;

public interface IStudentUserExamService extends IUserExamService {
    UserExamDetail submitExam(SubmitExamRequest request, UUID userExamId) throws InvalidException;

    UserExamDetail getQuestion(UUID id) throws InvalidException;
}
