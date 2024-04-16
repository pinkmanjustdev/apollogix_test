package com.apollogix.exam.modules.user.filter;

import com.apollogix.exam.modules.common.model.IFilter;
import lombok.*;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserFilter implements IFilter {
    private String email;
}
