package com.apollogix.exam.modules.user.model;

import com.apollogix.exam.modules.common.model.BaseModelData;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class UserInfo extends BaseModelData<UUID> {
    private String userRole;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String password;

    private String username;

}
