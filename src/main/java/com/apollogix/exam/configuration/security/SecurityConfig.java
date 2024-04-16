package com.apollogix.exam.configuration.security;

import com.apollogix.exam.configuration.properties.SecurityProperties;
import com.apollogix.exam.modules.common.exception.ErrorCode;
import com.apollogix.exam.modules.common.exception.RestException;
import com.apollogix.exam.modules.user.enumerate.UserRole;
import com.apollogix.exam.modules.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Configuration
public class SecurityConfig {
    protected final SecurityProperties securityProperties;
    private final IUserService iUserService;
    private final BearerTokenFilter bearerTokenFilter;

    public SecurityConfig(SecurityProperties securityProperties, IUserService iUserService, BearerTokenFilter bearerTokenFilter) {
        this.securityProperties = securityProperties;
        this.iUserService = iUserService;
        this.bearerTokenFilter = bearerTokenFilter;
    }

    public SecurityFilterChain filterChain(HttpSecurity http) {
        try {
            http.cors().and().csrf().disable()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            this.cors(http);
            this.configureAuthorizeRequests(http);
            http.addFilterBefore(bearerTokenFilter, LogoutFilter.class);
            return http.build();
        } catch (Exception e) {
            throw RestException.create(ErrorCode.SERVER_ERROR, e);
        }
    }

    protected void configureAuthorizeRequests(HttpSecurity http) throws Exception {
        SecurityProperties.PathMatcherConfig pathMatcherConfig = this.securityProperties.getPathMatcher();
        http.authorizeRequests().antMatchers("/api/v1/teacher/**").hasAuthority(UserRole.TEACHER.getCode());
        http.authorizeRequests().antMatchers("/api/v1/student/**").hasAuthority(UserRole.STUDENT.getCode());
        if (Objects.nonNull(pathMatcherConfig) && pathMatcherConfig.getPermitAllPathPatterns() != null) {
            for (String pattern : pathMatcherConfig.getPermitAllPathPatterns()) {
                http.authorizeRequests().antMatchers(pattern).permitAll();
            }
        }
        http.authorizeRequests().anyRequest().authenticated().and().exceptionHandling()
                .authenticationEntryPoint(
                        new DefaultAuthenticationEntryPoint()
                );
    }

    protected void cors(HttpSecurity http) throws Exception {
        CorsConfiguration configuration = buildCorsConfiguration();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        http.cors(cors -> cors.configurationSource(source));
    }

    protected CorsConfiguration buildCorsConfiguration() {
        SecurityProperties.Cors cors = this.securityProperties.getCors();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        if (Objects.nonNull(cors)) {
            if (Objects.nonNull(cors.getAllowedOrigins())) {
                List<String> origins = new ArrayList<>();
                for (String allowedOrigin : cors.getAllowedOrigins()) {
                    origins.addAll(Arrays.asList(allowedOrigin.split("\\s*,\\s*")));
                }
                configuration.setAllowedOrigins(origins);
            }

            if (Objects.nonNull(cors.getAllowedMethods())) {
                configuration.setAllowedMethods(cors.getAllowedMethods());
            }

            if (Objects.nonNull(cors.getAllowedHeaders())) {
                configuration.setAllowedHeaders(cors.getAllowedHeaders());
            }
        }
        return configuration;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(iUserService);

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
