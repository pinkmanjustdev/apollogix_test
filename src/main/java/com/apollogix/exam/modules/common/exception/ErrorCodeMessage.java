package com.apollogix.exam.modules.common.exception;

import org.springframework.context.i18n.LocaleContextHolder;

public interface ErrorCodeMessage extends IErrorCode {
    String VI = "vi";
    String EN = "en";

    /**
     * getEnMessage
     *
     * @return String
     */
    String getEnMessage();

    /**
     * getViMessage
     *
     * @return String
     */
    String getViMessage();

    default String getMessage() {
        if (VI.equals(LocaleContextHolder.getLocale().getLanguage())) {
            return getViMessage();
        } else {
            return getEnMessage();
        }
    }
}
