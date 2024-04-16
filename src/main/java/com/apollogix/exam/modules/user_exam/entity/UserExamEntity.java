package com.apollogix.exam.modules.user_exam.entity;

import com.apollogix.exam.modules.common.entity.BaseEntity;
import com.apollogix.exam.modules.exam.entity.ExamEntity;
import com.apollogix.exam.modules.user.entity.UserEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.UUID;

@Table(
        name = "user_exam"
)
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class UserExamEntity extends BaseEntity {

    @Column(name = "score")
    private Long score;

    @Column(name = "correct")
    private Integer correct;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "exam_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_user_user_exam"),
            columnDefinition = "UUID",
            insertable = false,
            updatable = false
    )
    private ExamEntity exam;

    @Column(name = "exam_id", nullable = false)
    private UUID examId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_user_user_exam"),
            columnDefinition = "UUID",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private UserEntity user;

    @Column(name = "student_id", nullable = false)
    private UUID studentId;

    @Column(name = "is_submit", columnDefinition = "boolean default false")
    private boolean isSubmit;
}
