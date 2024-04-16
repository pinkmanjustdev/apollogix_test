package com.apollogix.exam.modules.account.authenication.controller;

import com.apollogix.exam.modules.account.authenication.model.request.LoginRequest;
import com.apollogix.exam.modules.account.authenication.model.request.RefreshTokenRequest;
import com.apollogix.exam.modules.account.authenication.model.response.LoginResponse;
import com.apollogix.exam.modules.account.authenication.model.response.RefreshTokenResponse;
import com.apollogix.exam.modules.common.model.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface IAuthController {
    /**
     * login
     *
     * @param request LoginRequest
     * @return LoginResponse
     */
    @Operation(summary = "Đăng nhập")
    @PostMapping(path = "login")
    @SecurityRequirements
    ResponseEntity<BaseResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request);

    /**
     * refreshToken
     *
     * @param request RefreshTokenRequest
     * @return RefreshTokenResponse
     */
    @Operation(summary = "Refresh token")
    @PostMapping(path = "refresh-token")
    @SecurityRequirements
    ResponseEntity<BaseResponse<RefreshTokenResponse>> refreshToken(@Valid @RequestBody RefreshTokenRequest request);
}
