package com.apollogix.exam.modules.exam.controller.impl;

import com.apollogix.exam.modules.common.controller.BaseController;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.exception.RestException;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import com.apollogix.exam.modules.common.service.IResponseFactory;
import com.apollogix.exam.modules.exam.controller.ITeacherExamController;
import com.apollogix.exam.modules.exam.model.ExamDetail;
import com.apollogix.exam.modules.exam.model.ExamInfo;
import com.apollogix.exam.modules.exam.model.filter.ExamFilter;
import com.apollogix.exam.modules.exam.service.ITeacherExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/teacher/exam")
@Tag(name = "TeacherExamController", description = "Teacher Exam api")
public class TeacherExamController extends BaseController implements ITeacherExamController {
    private final ITeacherExamService iExamService;
    private final IResponseFactory iResponseFactory;

    public TeacherExamController(ITeacherExamService iExamService, IResponseFactory iResponseFactory) {
        this.iExamService = iExamService;
        this.iResponseFactory = iResponseFactory;
    }

    @Override
    @Operation(summary = "Create exam")
    public ResponseEntity<BaseResponse<ExamDetail>> createModel(ExamDetail request) {
        try {
            return iResponseFactory.success(iExamService.createModel(request));

        } catch (InvalidException e) {
            throw RestException.create(e);
        }

    }

    @Override
    @Operation(summary = "Get exam detail by id")
    public ResponseEntity<BaseResponse<ExamDetail>> getDetailById(UUID id) {
        try {
            return iResponseFactory.success(iExamService.getDetailModel(id));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }


    @Override
    @Operation(summary = "Update Exam")
    public ResponseEntity<BaseResponse<ExamDetail>> updateIdModel(UUID id, ExamDetail request) {
        try {
            return iResponseFactory.success(iExamService.updateModel(id, request));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }

    @Override
    @Operation(summary = "Paging filter exam")
    public ResponseEntity<BaseResponse<BasePagingResponse<ExamInfo>>> getInfoPageWithFilter(ExamFilter filter, Integer number, Integer size) {
        try {
            return iResponseFactory.success(iExamService.getInfoPage(filter, number, size));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }
}
