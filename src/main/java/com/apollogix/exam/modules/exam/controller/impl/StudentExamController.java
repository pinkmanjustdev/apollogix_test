package com.apollogix.exam.modules.exam.controller.impl;

import com.apollogix.exam.modules.common.controller.BaseController;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.exception.RestException;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import com.apollogix.exam.modules.common.service.IResponseFactory;
import com.apollogix.exam.modules.exam.controller.IStudentExamController;
import com.apollogix.exam.modules.exam.model.ExamDetail;
import com.apollogix.exam.modules.exam.model.ExamInfo;
import com.apollogix.exam.modules.exam.model.filter.ExamFilter;
import com.apollogix.exam.modules.exam.service.IStudentExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/student/exam")
@Tag(name = "StudentExamController", description = "Student Exam api")
public class StudentExamController extends BaseController implements IStudentExamController {
    private final IStudentExamService iExamService;
    private final IResponseFactory iResponseFactory;

    public StudentExamController(IStudentExamService iExamService, IResponseFactory iResponseFactory) {
        this.iExamService = iExamService;
        this.iResponseFactory = iResponseFactory;
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
    @Operation(summary = "Paging filter exam (todo)")
    public ResponseEntity<BaseResponse<BasePagingResponse<ExamInfo>>> getInfoPageWithFilter(ExamFilter filter, Integer number, Integer size) {
        try {
            return iResponseFactory.success(iExamService.getInfoPage(filter, number, size));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }
}
