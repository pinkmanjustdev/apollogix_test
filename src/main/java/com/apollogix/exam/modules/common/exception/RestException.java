package com.apollogix.exam.modules.common.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Extent RuntimeException and CustomException
 * <br>
 * Often using in last step RESTful
 */
public class RestException extends RuntimeException implements CustomException {
    /**
     * Error code
     */
    private final transient IErrorCode errorCode;
    /**
     * Args
     */
    private final Map<String, String> args;

    /**
     * @param errorCode error code
     * @param args      args
     * @param cause     cause
     */
    private RestException(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
        super(CustomException.errorResponse(errorCode, args), cause);
        this.errorCode = errorCode;
        this.args = Objects.requireNonNullElseGet(args, HashMap::new);
    }

    /**
     * @param errorCode implement of IErrorCode
     * @return RestException
     */
    public static RestException create(IErrorCode errorCode) {
        return create(errorCode, null, null);
    }

    /**
     * Create
     *
     * @param customException implement of CustomException
     * @return RestException
     */
    public static RestException create(CustomException customException) {
        return create(
                customException.getErrorCode(),
                customException.getArgs(),
                customException.getCause() != null ?
                        customException.getCause() :
                        (Exception) customException
        );
    }

    /**
     * @param errorCode implement of IErrorCode
     * @param cause     cause
     * @return RestException
     */
    public static RestException create(IErrorCode errorCode, Throwable cause) {
        return create(errorCode, null, cause);
    }

    /**
     * @param errorCode error code
     * @param args      args
     * @return RestException
     */
    public static RestException create(IErrorCode errorCode, Map<String, String> args) {
        return create(errorCode, args, null);
    }

    /**
     * Create RestException
     *
     * @param errorCode Error Code
     * @param args      args
     * @param cause     cause
     * @return RestException
     */
    public static RestException create(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
        return switch (errorCode.getStatusMapping().getHttpStatus()) {
            case BAD_REQUEST -> new BadRequest(errorCode, args, cause);
            case UNAUTHORIZED -> new Unauthorized(errorCode, args, cause);
            case FORBIDDEN -> new Forbidden(errorCode, args, cause);
            case NOT_FOUND -> new NotFound(errorCode, args, cause);
            case METHOD_NOT_ALLOWED -> new MethodNotAllowed(errorCode, args, cause);
            case NOT_ACCEPTABLE -> new NotAcceptable(errorCode, args, cause);
            case CONFLICT -> new Conflict(errorCode, args, cause);
            case GONE -> new Gone(errorCode, args, cause);
            case UNSUPPORTED_MEDIA_TYPE -> new UnsupportedMediaType(errorCode, args, cause);
            case TOO_MANY_REQUESTS -> new TooManyRequests(errorCode, args, cause);
            case UNPROCESSABLE_ENTITY -> new UnprocessableEntity(errorCode, args, cause);
            case INTERNAL_SERVER_ERROR -> new InternalServerError(errorCode, args, cause);
            default -> RestException.create(errorCode, args, cause);
        };
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
    public RestException append(String key, String value) {
        args.put(key, value);
        return this;
    }

    /**
     * Bad request
     */
    public static class BadRequest extends RestException {
        private BadRequest(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * Unauthorized
     */
    public static class Unauthorized extends RestException {
        private Unauthorized(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * Forbidden
     */
    public static class Forbidden extends RestException {
        private Forbidden(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * NotFound
     */
    public static class NotFound extends RestException {
        private NotFound(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * MethodNotAllowed
     */
    public static class MethodNotAllowed extends RestException {
        private MethodNotAllowed(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * NotAcceptable
     */
    public static class NotAcceptable extends RestException {
        private NotAcceptable(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * Conflict
     */
    public static class Conflict extends RestException {
        private Conflict(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * InternalServerError
     */
    public static class InternalServerError extends RestException {
        private InternalServerError(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * Gone
     */
    public static class Gone extends RestException {
        private Gone(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * UnsupportedMediaType
     */
    public static class UnsupportedMediaType extends RestException {
        private UnsupportedMediaType(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * UnprocessableEntity
     */
    public static class UnprocessableEntity extends RestException {
        private UnprocessableEntity(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }

    /**
     * TooManyRequests
     */
    public static class TooManyRequests extends RestException {
        private TooManyRequests(IErrorCode errorCode, Map<String, String> args, Throwable cause) {
            super(errorCode, args, cause);
        }
    }
}
