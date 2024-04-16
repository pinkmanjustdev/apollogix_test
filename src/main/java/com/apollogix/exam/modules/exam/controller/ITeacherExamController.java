package com.apollogix.exam.modules.exam.controller;

import com.apollogix.exam.modules.common.controller.ICreateModelController;
import com.apollogix.exam.modules.common.controller.IGetDetailByIdController;
import com.apollogix.exam.modules.common.controller.IGetInfoPageController;
import com.apollogix.exam.modules.common.controller.IUpdateIdModelController;
import com.apollogix.exam.modules.exam.model.ExamDetail;
import com.apollogix.exam.modules.exam.model.ExamInfo;
import com.apollogix.exam.modules.exam.model.filter.ExamFilter;

import java.util.UUID;

public interface ITeacherExamController extends ICreateModelController<UUID, ExamDetail>,
        IGetDetailByIdController<UUID, ExamDetail>,
        IGetInfoPageController<UUID, ExamInfo, ExamFilter>, IUpdateIdModelController<UUID, ExamDetail> {
}
