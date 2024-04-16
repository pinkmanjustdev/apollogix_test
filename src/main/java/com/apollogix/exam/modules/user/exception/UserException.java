package com.apollogix.exam.modules.user.exception;

import com.apollogix.exam.modules.common.exception.DomainError;
import com.apollogix.exam.modules.common.exception.ErrorCodeMessage;
import com.apollogix.exam.modules.common.exception.StatusMapping;
import lombok.Getter;


@Getter
public enum UserException implements ErrorCodeMessage {
    USER_NOT_FOUND(
            StatusMapping.NOT_FOUND,
            "User not found",
            "Không tìm thấy user"
    );
    private final StatusMapping statusMapping;

    private final int code;
    private final String enMessage;
    private final String viMessage;

    UserException(StatusMapping statusMapping, String enMessage, String viMessage) {
        this.statusMapping = statusMapping;
        this.enMessage = enMessage;
        this.viMessage = viMessage;
        this.code = DomainError.USER.getCode() * 10000
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
