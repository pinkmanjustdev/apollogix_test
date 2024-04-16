package com.apollogix.exam.modules.user.service.impl;

import com.apollogix.exam.modules.user.entity.UserEntity;
import com.apollogix.exam.modules.user.repository.UserRepository;
import com.apollogix.exam.modules.user.service.ITeacherUserService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public class StudentUserService extends UserService implements ITeacherUserService {
    protected StudentUserService(PagingAndSortingRepository<UserEntity, UUID> repository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        super(repository, userRepository, passwordEncoder);
    }
}
