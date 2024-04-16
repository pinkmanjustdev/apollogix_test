package com.apollogix.exam.configuration.security;

import com.apollogix.exam.modules.common.exception.CustomException;
import com.apollogix.exam.modules.common.exception.IErrorCode;
import org.springframework.security.core.AuthenticationException;

import java.util.HashMap;
import java.util.Map;

/**
 * DefaultAuthenticationException
 *
 * @see AuthenticationException
 * @see CustomException
 */
public class DefaultAuthenticationException extends AuthenticationException implements CustomException {
    /**
     * Error code
     */
    private final transient IErrorCode iErrorCode;
    /**
     * Args
     */
    private final Map<String, String> args;
    /**
     * Error message
     */

    /**
     * @param errorCode {@link IErrorCode}
     */
    public DefaultAuthenticationException(IErrorCode errorCode) {
        super(errorCode.name());
        this.iErrorCode = errorCode;
        this.args = new HashMap<>();
    }

    @Override
    public IErrorCode getErrorCode() {
        return this.iErrorCode;
    }

    @Override
    public Map<String, String> getArgs() {
        return args;
    }

    @Override
    public DefaultAuthenticationException append(String key, String value) {
        args.put(key, value);
        return this;
    }
}