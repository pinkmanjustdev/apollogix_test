package com.apollogix.exam.configuration.security;

import com.apollogix.exam.configuration.properties.SecurityProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security config
 */
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfiguration {

    @Bean
    @ConditionalOnMissingBean
    SecurityFilterChain filterChain(HttpSecurity http, SecurityConfig config) {
        return config.filterChain(http);
    }

}
