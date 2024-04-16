package com.apollogix.exam.modules.question.controller;

import com.apollogix.exam.modules.common.controller.ICreateModelController;
import com.apollogix.exam.modules.common.controller.IGetDetailByIdController;
import com.apollogix.exam.modules.common.controller.IGetInfoPageController;
import com.apollogix.exam.modules.common.controller.IUpdateIdModelController;
import com.apollogix.exam.modules.question.filter.QuestionBankFilter;
import com.apollogix.exam.modules.question.model.QuestionBankDetail;
import com.apollogix.exam.modules.question.model.QuestionBankInfo;

import java.util.UUID;

public interface ITeacherQuestionController extends ICreateModelController<UUID, QuestionBankDetail>,
        IGetDetailByIdController<UUID, QuestionBankDetail>,
        IUpdateIdModelController<UUID, QuestionBankDetail>,
        IGetInfoPageController<UUID, QuestionBankInfo, QuestionBankFilter> {
}
