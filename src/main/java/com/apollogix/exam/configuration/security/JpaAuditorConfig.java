package com.apollogix.exam.configuration.security;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;
import java.util.UUID;

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
public class JpaAuditorConfig extends DefaultAuditorAware {
    @Override
    public @NonNull Optional<UUID> getCurrentAuditor() {
        return super.getCurrentAuditor();
    }
}
