package com.apollogix.exam.modules.account.authenication.service;

import com.apollogix.exam.modules.account.authenication.model.request.LoginRequest;
import com.apollogix.exam.modules.account.authenication.model.response.LoginResponse;
import com.apollogix.exam.modules.common.exception.InvalidException;

public interface IAuthenicationService {
    LoginResponse authenticate(LoginRequest request) throws InvalidException;
}
