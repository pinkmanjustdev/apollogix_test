package com.apollogix.exam.modules.account.authenication.service;

import com.apollogix.exam.modules.account.authenication.model.request.LoginRequest;
import com.apollogix.exam.modules.account.authenication.model.response.LoginResponse;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.user.enumerate.UserRole;
import com.apollogix.exam.modules.user.model.UserDetail;
import com.apollogix.exam.modules.user.service.IUserService;
import com.apollogix.exam.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService implements IAuthenicationService {
    private final IUserService iUserService;

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(IUserService iUserService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.iUserService = iUserService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;

    }

    public LoginResponse authenticate(LoginRequest request) throws InvalidException {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetail userDetail = iUserService.getUserByEmail(request.getUsername());

        String token = jwtUtil.createToken(userDetail, UserRole.STUDENT);
        SecurityContextHolder.getContext().setAuthentication(authentication);


        return LoginResponse.builder()
                .token(token)
                .build();
    }
}
