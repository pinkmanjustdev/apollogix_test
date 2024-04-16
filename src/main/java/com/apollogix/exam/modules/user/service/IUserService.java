package com.apollogix.exam.modules.user.service;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.service.IDataService;
import com.apollogix.exam.modules.user.entity.UserEntity;
import com.apollogix.exam.modules.user.model.UserDetail;
import com.apollogix.exam.modules.user.model.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface IUserService extends IDataService<UUID, UserInfo, UserDetail>, UserDetailsService {
    UserDetail getUserByEmail(String email) throws InvalidException;

    UserEntity getEntity(UUID id);
}
