package com.apollogix.exam.modules.user.entity;

import com.apollogix.exam.modules.common.entity.BaseEntity;
import com.apollogix.exam.modules.user.enumerate.UserRole;
import com.apollogix.exam.modules.user_exam.entity.UserExamEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(
        name = "users"
)
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class UserEntity extends BaseEntity {

    @Transient
    private UserRole userRoleEnum;

    @Basic
    @Column(name = "user_role", nullable = false)
    private String userRole;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder.Default
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<UserExamEntity> userExams = new HashSet<>();

    @PostLoad
    void fillTransient() {
        if (userRole != null) {
            this.userRoleEnum = UserRole.of(userRole);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (userRoleEnum != null) {
            this.userRole = userRoleEnum.getCode();
        }
    }
}
