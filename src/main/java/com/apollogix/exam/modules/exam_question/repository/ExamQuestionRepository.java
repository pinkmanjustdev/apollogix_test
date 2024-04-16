package com.apollogix.exam.modules.exam_question.repository;

import com.apollogix.exam.modules.exam_question.entity.ExamQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExamQuestionRepository extends JpaRepository<ExamQuestionEntity, UUID> {
}
