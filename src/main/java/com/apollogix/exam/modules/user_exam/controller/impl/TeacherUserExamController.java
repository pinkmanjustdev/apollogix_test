package com.apollogix.exam.modules.user_exam.controller.impl;

import com.apollogix.exam.modules.common.controller.BaseController;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.exception.RestException;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.service.IResponseFactory;
import com.apollogix.exam.modules.user_exam.controller.ITeacherUserExamController;
import com.apollogix.exam.modules.user_exam.model.UserExamDetail;
import com.apollogix.exam.modules.user_exam.service.IStudentUserExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/teacher/user-exam")
@Tag(name = "TeacherUserExamController", description = "Student User Exam api")
public class TeacherUserExamController extends BaseController implements ITeacherUserExamController {
    private final IStudentUserExamService iUserExamService;

    private final IResponseFactory iResponseFactory;

    public TeacherUserExamController(IStudentUserExamService iUserExamService, IResponseFactory iResponseFactory) {
        this.iUserExamService = iUserExamService;
        this.iResponseFactory = iResponseFactory;
    }

    @Override
    @Operation(summary = "Get user exam detail by id")
    public ResponseEntity<BaseResponse<UserExamDetail>> getDetailById(UUID id) {
        try {
            return iResponseFactory.success(iUserExamService.getDetailModel(id));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }

    @Override
    public ResponseEntity<BaseResponse<UserExamDetail>> createModel(UserExamDetail request) {
        return null;
    }
}
