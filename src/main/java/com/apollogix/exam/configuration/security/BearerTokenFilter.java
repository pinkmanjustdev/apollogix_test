package com.apollogix.exam.configuration.security;

import com.apollogix.exam.modules.common.exception.ErrorCode;
import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.user.model.UserDetail;
import com.apollogix.exam.modules.user.service.IUserService;
import com.apollogix.exam.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class BearerTokenFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final IUserService iUserService;
    private final AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new WebAuthenticationDetailsSource();
    private final AuthenticationEntryPoint authenticationEntryPoint = new DefaultAuthenticationEntryPoint();

    public BearerTokenFilter(JwtUtil jwtUtil, @Qualifier("userService") IUserService iUserService) {
        this.jwtUtil = jwtUtil;
        this.iUserService = iUserService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token;
        try {
            token = jwtUtil.resolveToken(request);
        } catch (OAuth2AuthenticationException invalid) {
            authenticationEntryPoint.commence(request, response, new DefaultAuthenticationException(ErrorCode.UNAUTHORIZED));
            return;
        }
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        Claims claims = jwtUtil.resolveClaims(request);
        try {
            UserDetail userDetail = iUserService.getUserByEmail(claims.getSubject());

            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
            SecurityContext context = SecurityContextHolder.createEmptyContext();

            context.setAuthentication(authentication);

            SecurityContextHolder.setContext(context);
        } catch (AuthenticationException failed) {
            SecurityContextHolder.clearContext();
        } catch (InvalidException e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(request, response);

    }
}
