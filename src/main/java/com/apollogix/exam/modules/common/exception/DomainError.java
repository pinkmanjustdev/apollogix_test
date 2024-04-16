package com.apollogix.exam.modules.common.exception;

public enum DomainError {
    ACCOUNT(1),
    EXAM(2),
    EXAM_QUESTION(3),
    QUESTION(4),
    USER(5),
    USER_EXAM(6);


    private final int code;


    DomainError(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
