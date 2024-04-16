package com.apollogix.exam.modules.exam_question.entity;

import com.apollogix.exam.modules.common.entity.BaseEntity;
import com.apollogix.exam.modules.exam.entity.ExamEntity;
import com.apollogix.exam.modules.question.entity.QuestionBankEntity;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.UUID;

@Table(
        name = "exam_question"
)
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class ExamQuestionEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "exam_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_exam_exam_question"),
            columnDefinition = "UUID",
            insertable = false,
            updatable = false
    )
    private ExamEntity exam;

    @Column(name = "exam_id", nullable = false)
    private UUID examId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "question_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_question_exam_question"),
            columnDefinition = "UUID",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private QuestionBankEntity questionBank;

    @Column(name = "question_id", nullable = false)
    private UUID questionId;

}
