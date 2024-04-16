package com.apollogix.exam.modules.user_exam.repository;

import com.apollogix.exam.modules.user_exam.entity.UserExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserExamRepository extends JpaRepository<UserExamEntity, UUID> {
}
