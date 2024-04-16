package com.apollogix.exam.modules.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Mapping between grpc status and http status
 */
public enum StatusMapping {
    /**
     * Ok
     */
    OK(HttpStatus.OK),
    /**
     * Bad request
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    /**
     * Request timeout
     */
    REQUEST_TIMEOUT(HttpStatus.REQUEST_TIMEOUT),
    /**
     * Not found
     */
    NOT_FOUND(HttpStatus.BAD_REQUEST),
    /**
     * Permission denied
     */
    PERMISSION_DENIED(HttpStatus.FORBIDDEN),
    /**
     * Unimplemented
     */
    UNIMPLEMENTED(HttpStatus.NOT_FOUND),
    /**
     * Internal server error
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    /**
     * Service unavailable
     */
    UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE),
    /**
     * Unauthorized
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED),
    /**
     * Conflict
     */
    CONFLICT(HttpStatus.CONFLICT),

    /**
     * Already exists
     */
    ALREADY_EXISTS(HttpStatus.CONFLICT);

    private final HttpStatus httpStatus;

    StatusMapping(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
