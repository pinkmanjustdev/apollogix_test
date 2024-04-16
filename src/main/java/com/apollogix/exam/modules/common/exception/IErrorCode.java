package com.apollogix.exam.modules.common.exception;

/**
 * Interface for error code
 */
public interface IErrorCode {

    /**
     * @return Status mapping
     */
    StatusMapping getStatusMapping();

    /**
     * @return Error code
     */
    int getCode();

    /**
     * @return enum name
     */
    String name();

}
