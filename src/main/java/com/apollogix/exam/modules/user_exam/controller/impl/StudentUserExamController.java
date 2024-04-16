package com.apollogix.exam.modules.user_exam.controller.impl;

import com.apollogix.exam.modules.common.controller.BaseController;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.exception.RestException;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.service.IResponseFactory;
import com.apollogix.exam.modules.user_exam.controller.IStudentUserExamController;
import com.apollogix.exam.modules.user_exam.model.UserExamDetail;
import com.apollogix.exam.modules.user_exam.model.request.SubmitExamRequest;
import com.apollogix.exam.modules.user_exam.service.IStudentUserExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/student/user-exam")
@Tag(name = "StudentUserExamController", description = "Student User Exam api")
public class StudentUserExamController extends BaseController implements IStudentUserExamController {
    private final IStudentUserExamService iUserExamService;

    private final IResponseFactory iResponseFactory;

    public StudentUserExamController(IStudentUserExamService iUserExamService, IResponseFactory iResponseFactory) {
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
    @Operation(summary = "Get user exam question")
    public ResponseEntity<BaseResponse<UserExamDetail>> getUserExamQuestion(UUID id) {
        try {
            return iResponseFactory.success(iUserExamService.getQuestion(id));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }

    @Override
    @Operation(summary = "Submit exam answer")
    public ResponseEntity<BaseResponse<UserExamDetail>> submitExam(UUID id, SubmitExamRequest request) {
        try {
            return iResponseFactory.success(iUserExamService.submitExam(request, id));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }

}
