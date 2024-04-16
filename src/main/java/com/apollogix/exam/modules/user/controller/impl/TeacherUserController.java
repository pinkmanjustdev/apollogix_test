package com.apollogix.exam.modules.user.controller.impl;

import com.apollogix.exam.modules.common.controller.BaseController;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.exception.RestException;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import com.apollogix.exam.modules.common.service.IResponseFactory;
import com.apollogix.exam.modules.user.controller.ITeacherUserController;
import com.apollogix.exam.modules.user.filter.UserFilter;
import com.apollogix.exam.modules.user.model.UserDetail;
import com.apollogix.exam.modules.user.model.UserInfo;
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
@RequestMapping("/api/v1/teacher/users")
@Tag(name = "TeacherUserController", description = "Teacher User api")
public class TeacherUserController extends BaseController implements ITeacherUserController {
    private final IUserService iUserService;

    private final IResponseFactory iResponseFactory;

    public TeacherUserController(IUserService iUserService, IResponseFactory iResponseFactory) {
        this.iUserService = iUserService;
        this.iResponseFactory = iResponseFactory;
    }

    @Override
    @Operation(summary = "Create user")
    public ResponseEntity<BaseResponse<UserDetail>> createModel(UserDetail request) {
        try {
            return iResponseFactory.success(iUserService.createModel(request));

        } catch (InvalidException e) {
            throw RestException.create(e);
        }
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

    @Override
    public ResponseEntity<BaseResponse<BasePagingResponse<UserInfo>>> getInfoPageWithFilter(UserFilter filter, Integer number, Integer size) {
        return null;
    }
}
