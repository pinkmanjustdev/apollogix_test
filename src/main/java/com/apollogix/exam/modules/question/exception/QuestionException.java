package com.apollogix.exam.modules.question.exception;

import com.apollogix.exam.modules.common.exception.DomainError;
import com.apollogix.exam.modules.common.exception.ErrorCodeMessage;
import com.apollogix.exam.modules.common.exception.StatusMapping;
import lombok.Getter;


@Getter
public enum QuestionException implements ErrorCodeMessage {
    QUESTION_NOT_FOUND(
            StatusMapping.NOT_FOUND,
            "Question not found",
            "Không tìm thấy question"
    );
    private final StatusMapping statusMapping;

    private final int code;
    private final String enMessage;
    private final String viMessage;

    QuestionException(StatusMapping statusMapping, String enMessage, String viMessage) {
        this.statusMapping = statusMapping;
        this.enMessage = enMessage;
        this.viMessage = viMessage;
        this.code = DomainError.QUESTION.getCode() * 10000
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
