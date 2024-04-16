package com.apollogix.exam.modules.user.controller;

import com.apollogix.exam.modules.common.controller.ICreateModelController;
import com.apollogix.exam.modules.common.controller.IGetDetailByIdController;
import com.apollogix.exam.modules.common.controller.IGetInfoPageController;
import com.apollogix.exam.modules.user.filter.UserFilter;
import com.apollogix.exam.modules.user.model.UserDetail;
import com.apollogix.exam.modules.user.model.UserInfo;

import java.util.UUID;

public interface ITeacherUserController extends ICreateModelController<UUID, UserDetail>,
        IGetDetailByIdController<UUID, UserDetail>,
        IGetInfoPageController<UUID, UserInfo, UserFilter> {
}
