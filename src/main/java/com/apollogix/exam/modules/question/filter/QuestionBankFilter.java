package com.apollogix.exam.modules.question.filter;

import com.apollogix.exam.modules.common.model.IFilter;
import lombok.*;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionBankFilter implements IFilter {
    private String searchText;
}
