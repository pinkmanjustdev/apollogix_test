package com.apollogix.exam.modules.question.controller;

import com.apollogix.exam.modules.common.controller.IGetDetailByIdController;
import com.apollogix.exam.modules.common.controller.IGetInfoPageController;
import com.apollogix.exam.modules.question.filter.QuestionBankFilter;
import com.apollogix.exam.modules.question.model.QuestionBankDetail;
import com.apollogix.exam.modules.question.model.QuestionBankInfo;

import java.util.UUID;

public interface IStudentQuestionController extends IGetDetailByIdController<UUID, QuestionBankDetail>, IGetInfoPageController<UUID, QuestionBankInfo, QuestionBankFilter> {
}
