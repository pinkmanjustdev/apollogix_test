package com.apollogix.exam.modules.common.service;

import com.apollogix.exam.modules.common.exception.IErrorCode;
import com.apollogix.exam.modules.common.model.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface IResponseFactory {
    /**
     * Success
     *
     * @param data data
     * @param <I>  data type
     * @return {@link ResponseEntity}
     */
    <I> ResponseEntity<BaseResponse<I>> success(I data);

    /**
     * Error from {@link IErrorCode}
     *
     * @param errorCode error code
     * @return {@link ResponseEntity}
     */
//    ResponseEntity<ErrorResponse> error(IErrorCode errorCode);
//
//    /**
//     * Error from {@link IErrorCode} and fields error
//     *
//     * @param errorCode   error code
//     * @param fieldsError field error
//     * @return {@link ResponseEntity}
//     */
//    ResponseEntity<ErrorResponse> error(IErrorCode errorCode, Map<String, String> fieldsError);
//
//    /**
//     * Error from {@link CustomException}
//     *
//     * @param exception exception
//     * @return {@link ResponseEntity}
//     */
//    ResponseEntity<ErrorResponse> error(CustomException exception);
}