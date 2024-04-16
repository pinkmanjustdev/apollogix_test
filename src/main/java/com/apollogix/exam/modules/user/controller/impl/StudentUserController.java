package com.apollogix.exam.modules.user.controller.impl;

import com.apollogix.exam.modules.common.controller.BaseController;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.exception.RestException;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.service.IResponseFactory;
import com.apollogix.exam.modules.user.controller.IStudentUserController;
import com.apollogix.exam.modules.user.model.UserDetail;
import com.apollogix.exam.modules.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/student/users")
@Tag(name = "StudentUserController", description = "Student User api")
public class StudentUserController extends BaseController implements IStudentUserController {
    private final IUserService iUserService;

    private final IResponseFactory iResponseFactory;

    public StudentUserController(IUserService iUserService, IResponseFactory iResponseFactory) {
        this.iUserService = iUserService;
        this.iResponseFactory = iResponseFactory;
    }

    @Override
    @Operation(summary = "Get user detail by id")
    public ResponseEntity<BaseResponse<UserDetail>> getDetailById(UUID id) {
        try {
            return iResponseFactory.success(iUserService.getDetailModel(id));
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }
}
