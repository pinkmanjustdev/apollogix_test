package com.apollogix.exam.modules.user_exam.controller;

import com.apollogix.exam.modules.common.controller.ICreateModelController;
import com.apollogix.exam.modules.common.controller.IGetDetailByIdController;
import com.apollogix.exam.modules.user_exam.model.UserExamDetail;

import java.util.UUID;

public interface IUserExamController extends ICreateModelController<UUID, UserExamDetail>, IGetDetailByIdController<UUID, UserExamDetail> {
}
