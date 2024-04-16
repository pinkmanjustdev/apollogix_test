package com.apollogix.exam.modules.user_exam.controller;

import com.apollogix.exam.modules.common.controller.IGetDetailByIdController;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.user_exam.model.UserExamDetail;
import com.apollogix.exam.modules.user_exam.model.request.SubmitExamRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface IStudentUserExamController extends IGetDetailByIdController<UUID, UserExamDetail> {
    @GetMapping("{id}/questions")
    ResponseEntity<BaseResponse<UserExamDetail>> getUserExamQuestion(@PathVariable UUID id);

    @PostMapping("{id}/submit")
    ResponseEntity<BaseResponse<UserExamDetail>> submitExam(@PathVariable UUID id, @RequestBody SubmitExamRequest request);
}
