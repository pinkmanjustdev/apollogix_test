package com.apollogix.exam.modules.user.controller;

import com.apollogix.exam.modules.common.controller.IGetDetailByIdController;
import com.apollogix.exam.modules.user.model.UserDetail;

import java.util.UUID;

public interface IStudentUserController extends IGetDetailByIdController<UUID, UserDetail> {
}
