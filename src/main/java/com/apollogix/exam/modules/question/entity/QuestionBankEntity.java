package com.apollogix.exam.modules.question.entity;

import com.apollogix.exam.modules.common.entity.BaseEntity;
import com.apollogix.exam.modules.exam_question.entity.ExamQuestionEntity;
import com.apollogix.exam.modules.question.model.AnswerInfo;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(
        name = "question_bank"
)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class QuestionBankEntity extends BaseEntity {

    @Column(name = "question_key", nullable = false)
    private String questionKey;

    @Builder.Default
    @Column(name = "answer_choice", columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private List<AnswerInfo> answerChoices = new ArrayList<>();

    @Builder.Default
    @Column(name = "answers", columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private List<AnswerInfo> answers = new ArrayList<>();

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionBank")
    private Set<ExamQuestionEntity> examQuestions = new HashSet<>();

}