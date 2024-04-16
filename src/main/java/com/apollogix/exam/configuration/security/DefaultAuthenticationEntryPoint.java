package com.apollogix.exam.configuration.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DefaultAuthenticationEntryPoint
 */
@Slf4j
public class DefaultAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        log.trace("Unauthorized: {}", authException.getMessage());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
