package com.apollogix.exam.modules.common.service;

import com.apollogix.exam.modules.common.exception.IErrorCode;
import com.apollogix.exam.modules.common.model.BaseResponse;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DefaultResponseFactory implements IResponseFactory {
    /**
     * Six digits format
     */
    protected static final String SIX_DIGITS_FORMAT = "%06d";
    /**
     * Service name
     */
    protected final String servicePrefix;

    /**
     * DefaultResponseFactory
     *
     * @param environment {@link Environment}
     */
    public DefaultResponseFactory(Environment environment) {
        String serviceName = environment.getProperty("spring.application.name");
        if (serviceName != null) {
            this.servicePrefix = serviceName.toUpperCase();
        } else {
            this.servicePrefix = "";
        }
    }

    @Override
    public <I> ResponseEntity<BaseResponse<I>> success(I data) {
        BaseResponse<I> response = BaseResponse.
                <I>builder()
                .data(data)
                .success(true)
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        response
                );
    }

    /**
     * Get code
     *
     * @param iErrorCode {@link IErrorCode}
     * @return {@link String} error code
     */
    protected String getCode(IErrorCode iErrorCode) {
        return servicePrefix != null ? (servicePrefix.concat(String.format(SIX_DIGITS_FORMAT, iErrorCode.getCode())).toUpperCase()) : String.format(SIX_DIGITS_FORMAT, iErrorCode.getCode());
    }

}