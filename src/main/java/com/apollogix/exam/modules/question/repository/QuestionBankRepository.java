package com.apollogix.exam.modules.question.repository;

import com.apollogix.exam.modules.question.entity.QuestionBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBankEntity, UUID> {
}
