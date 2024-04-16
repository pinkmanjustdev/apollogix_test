package com.apollogix.exam.modules.exam.entity;

import com.apollogix.exam.modules.common.entity.BaseEntity;
import com.apollogix.exam.modules.exam_question.entity.ExamQuestionEntity;
import com.apollogix.exam.modules.user_exam.entity.UserExamEntity;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(
        name = "exam"
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
public class ExamEntity extends BaseEntity {

    @Column(name = "time_limit", nullable = false)
    private Integer timeLimit;

    @Builder.Default
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "exam",
            cascade = CascadeType.ALL
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<ExamQuestionEntity> examQuestions = new HashSet<>();

    @Builder.Default
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "exam",
            cascade = CascadeType.ALL
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<UserExamEntity> userExams = new HashSet<>();

    public void addExamQuestion(ExamQuestionEntity examQuestionEntity) {
        examQuestions.add(examQuestionEntity);
    }
}