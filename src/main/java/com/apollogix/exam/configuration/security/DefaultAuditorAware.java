package com.apollogix.exam.configuration.security;

import com.apollogix.exam.modules.user.model.UserDetail;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

@Slf4j
public class DefaultAuditorAware implements AuditorAware<UUID> {
    @Override
    @NonNull
    public Optional<UUID> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = null;
        try {
            UserDetail userDetail = (UserDetail) authentication.getPrincipal();
            return Optional.of(userDetail.getId());
        } catch (Exception e) {
            log.error("Error when get Auditor: UserId " + userId + " from MDC " + e.getClass().getSimpleName() + " " + e.getMessage());
        }
        return Optional.empty();
    }

}