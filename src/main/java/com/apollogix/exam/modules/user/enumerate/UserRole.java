package com.apollogix.exam.modules.user.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum UserRole {
    STUDENT("S"),
    TEACHER("T"),
    ;

    private final String code;

    public static UserRole of(final String code) {
        for (final UserRole u : UserRole.values()) {
            if (Objects.equals(u.getCode(), code)) {
                return u;
            }
        }
        return null;
    }
}
