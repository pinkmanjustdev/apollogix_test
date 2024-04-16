package com.apollogix.exam.modules.account.authenication.controller;

import com.apollogix.exam.modules.account.authenication.model.request.LoginRequest;
import com.apollogix.exam.modules.account.authenication.model.request.RefreshTokenRequest;
import com.apollogix.exam.modules.account.authenication.model.response.LoginResponse;
import com.apollogix.exam.modules.account.authenication.model.response.RefreshTokenResponse;
import com.apollogix.exam.modules.account.authenication.service.IAuthenicationService;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.model.BaseResponse;
import com.apollogix.exam.modules.common.service.IResponseFactory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "AuthController", description = "Auth api")
public class AuthController implements IAuthController {
    private final IAuthenicationService iAuthenicationService;
    private final IResponseFactory iResponseFactory;

    public AuthController(IAuthenicationService iAuthenicationService, IResponseFactory iResponseFactory) {

        this.iAuthenicationService = iAuthenicationService;
        this.iResponseFactory = iResponseFactory;
    }

    @Override
    public ResponseEntity<BaseResponse<LoginResponse>> login(LoginRequest request) {
        try {
            return iResponseFactory.success(iAuthenicationService.authenticate(request));
        } catch (InvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<BaseResponse<RefreshTokenResponse>> refreshToken(RefreshTokenRequest request) {
        return null;
    }
}
