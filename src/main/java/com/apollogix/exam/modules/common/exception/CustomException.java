package com.apollogix.exam.modules.common.exception;

import java.util.Map;

/**
 * Custom Exception Interface
 */
public interface CustomException {

    /**
     * @param errorCode implement of IErrorCode
     * @param args      args
     * @return Message error
     */
    static String errorResponse(IErrorCode errorCode, Map<String, String> args) {
        return errorCode.name();
    }

    /**
     * @return Error code
     */
    IErrorCode getErrorCode();

    /**
     * Message have value : Error at {abc}
     *
     * @return Message Error
     */
    default String getErrorMessage() {
        return getErrorCode().name();
    }

    /**
     * List arguments
     *
     * @return list arguments
     */
    Map<String, String> getArgs();

    /**
     * Append arg
     *
     * @param key   key
     * @param value value
     * @param <T>   Exception type
     * @return Exception extend custom exception
     */
    <T extends CustomException> T append(String key, String value);

    /**
     * Get cause
     *
     * @return throwable
     */
    Throwable getCause();
}
