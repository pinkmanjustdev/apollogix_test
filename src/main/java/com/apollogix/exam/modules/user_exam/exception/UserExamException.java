package com.apollogix.exam.modules.user_exam.exception;

import com.apollogix.exam.modules.common.exception.DomainError;
import com.apollogix.exam.modules.common.exception.ErrorCodeMessage;
import com.apollogix.exam.modules.common.exception.StatusMapping;
import lombok.Getter;


@Getter
public enum UserExamException implements ErrorCodeMessage {
    USER_EXAM_NOT_FOUND(
            StatusMapping.NOT_FOUND,
            "User exam not found",
            "Không tìm thấy user exam"
    );
    private final StatusMapping statusMapping;

    private final int code;
    private final String enMessage;
    private final String viMessage;

    UserExamException(StatusMapping statusMapping, String enMessage, String viMessage) {
        this.statusMapping = statusMapping;
        this.enMessage = enMessage;
        this.viMessage = viMessage;
        this.code = DomainError.USER_EXAM.getCode() * 10000
                + this.ordinal();
    }

    @Override
    public String getEnMessage() {
        return enMessage;
    }

    @Override
    public String getViMessage() {
        return viMessage;
    }
}
