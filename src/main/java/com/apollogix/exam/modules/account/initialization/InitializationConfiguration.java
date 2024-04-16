package com.apollogix.exam.modules.account.initialization;

import com.apollogix.exam.configuration.properties.InitializationProperties;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.user.enumerate.UserRole;
import com.apollogix.exam.modules.user.model.UserDetail;
import com.apollogix.exam.modules.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Slf4j
@Transactional
public class InitializationConfiguration {

    public InitializationConfiguration(
            IUserService iUserService,
            InitializationProperties properties
    ) {
        init(
                iUserService,
                properties
        );
    }

    @Transactional
    public void init(
            IUserService iUserService,
            InitializationProperties properties
    ) {
        UserDetail userDetail = null;
        try {
            userDetail = iUserService.getUserByEmail(properties.getEmail());
        } catch (InvalidException ignore) {
            //ignore
        }
        if (userDetail != null) {
            return;
        }
        try {
            log.warn("Create root user {}", properties.getEmail());
            userDetail = iUserService.createModel(
                    UserDetail
                            .builder()
                            .email(properties.getEmail())
                            .name(properties.getName())
                            .userRole(UserRole.TEACHER.getCode())
                            .password(properties.getPassword())
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
