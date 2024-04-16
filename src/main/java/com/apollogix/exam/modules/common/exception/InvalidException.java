package com.apollogix.exam.modules.common.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Implement CustomException and Exception
 * <br>
 * Often using in logic
 */
public class InvalidException extends Exception implements CustomException {
    /**
     * Error code
     */
    private final transient IErrorCode errorCode;
    /**
     * Args
     */
    private final Map<String, String> args;

    /**
     * @param errorCode implement of IErrorCode
     */
    public InvalidException(IErrorCode errorCode) {
        this(errorCode, null, null);
    }

    /**
     * @param errorCode error code
     * @param cause     cause
     */
    public InvalidException(IErrorCode errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    /**
     * @param errorCode error code
     * @param args      args
     * @param cause     cause
     */
    public InvalidException(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
        super(CustomException.errorResponse(errorCode, args), cause);
        this.errorCode = errorCode;
        this.args = Objects.requireNonNullElseGet(args, HashMap::new);
    }

    @Override
    public IErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public Map<String, String> getArgs() {
        return args;
    }

    @Override
    public InvalidException append(String key, String value) {
        args.put(key, value);
        return this;
    }

}
