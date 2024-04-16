package com.apollogix.exam.modules.question.controller.impl;

import com.apollogix.exam.modules.common.controller.BaseController;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.exception.RestException;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import com.apollogix.exam.modules.common.service.IResponseFactory;
import com.apollogix.exam.modules.question.controller.IStudentQuestionController;
import com.apollogix.exam.modules.question.filter.QuestionBankFilter;
import com.apollogix.exam.modules.question.model.QuestionBankDetail;
import com.apollogix.exam.modules.question.model.QuestionBankInfo;
import com.apollogix.exam.modules.question.service.IStudentQuestionBankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/student/question")
@Tag(name = "StudentQuestionController", description = "Student Question api")
public class StudentQuestionController extends BaseController implements IStudentQuestionController {
    private final IStudentQuestionBankService iQuestionBankService;
    private final IResponseFactory iResponseFactory;

    public StudentQuestionController(IStudentQuestionBankService iQuestionBankService, IResponseFactory iResponseFactory) {
        this.iQuestionBankService = iQuestionBankService;
        this.iResponseFactory = iResponseFactory;
    }

    @Override
    @Operation(summary = "Get question detail by id")
    public ResponseEntity<BaseResponse<QuestionBankDetail>> getDetailById(UUID id) {
        try {
            return iResponseFactory.success(iQuestionBankService.getDetailModel(id));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }

    @Override
    @Operation(summary = "Paging filter question")
    public ResponseEntity<BaseResponse<BasePagingResponse<QuestionBankInfo>>> getInfoPageWithFilter(QuestionBankFilter filter, Integer number, Integer size) {
        try {
            return iResponseFactory.success(iQuestionBankService.getInfoPage(filter, number, size));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }
}
