package com.apollogix.exam.modules.common.exception;

/**
 * Common error code
 */
public enum ErrorCode implements IErrorCode {
    /**
     * OK
     */
    OK(StatusMapping.OK, 2000000),

    /**
     * Server Error
     */
    SERVER_ERROR(StatusMapping.INTERNAL_SERVER_ERROR, 5000000),
    /**
     * Not found token provider
     */
    TOKEN_PROVIDER_NOTFOUND(StatusMapping.INTERNAL_SERVER_ERROR, 50000001),
    /**
     * Unsupported method
     */
    UNSUPPORTED_METHOD(StatusMapping.UNIMPLEMENTED, 5000002),
    /**
     * Model id type not same entity id type
     */
    CAN_NOT_CAST_ID_ERROR(StatusMapping.INTERNAL_SERVER_ERROR, 5000003),
    /**
     * Duplication assignment factory
     */
    DUPLICATE_SAME_ASSIGNMENT_FACTORY(StatusMapping.INTERNAL_SERVER_ERROR, 5000004),
    /**
     * Get cache error
     */
    GET_CACHE_ERROR(StatusMapping.INTERNAL_SERVER_ERROR, 5000005),

    /**
     * Unauthorized
     */
    UNAUTHORIZED(StatusMapping.UNAUTHORIZED, 4010000),
    /**
     * Invalid Token
     */
    INVALID_TOKEN(StatusMapping.UNAUTHORIZED, 4010001),
    /**
     * Invalid X-API-KEY
     */
    INVALID_X_API_KEY(StatusMapping.UNAUTHORIZED, 4010002),

    /**
     * Not Found
     */
    NOT_FOUND(StatusMapping.BAD_REQUEST, 40000002),

    /**
     * Conflict
     */
    CONFLICT(StatusMapping.CONFLICT, 4090000),

    /**
     * Invalid date
     */
    INVALID_DATE_TYPE(StatusMapping.CONFLICT, 40900001),
    /**
     * Convert error
     */
    CONVERT_TO_STRING_ERROR(StatusMapping.CONFLICT, 4090002),

    /**
     * Bad Request
     */
    BAD_REQUEST(StatusMapping.BAD_REQUEST, 40000000),

    /**
     * Internal bad Request
     */
    INTERNAL_BAD_REQUEST(StatusMapping.BAD_REQUEST, 40000001);

    private final StatusMapping statusMapping;
    private final int code;

    ErrorCode(StatusMapping statusMapping, int code) {
        this.statusMapping = statusMapping;
        this.code = code;
    }

    @Override
    public StatusMapping getStatusMapping() {
        return statusMapping;
    }

    @Override
    public int getCode() {
        return code;
    }

}
