package com.apollogix.exam.modules.user_exam.service.impl;

import com.apollogix.exam.modules.exam.service.IExamService;
import com.apollogix.exam.modules.user.service.IUserService;
import com.apollogix.exam.modules.user_exam.entity.UserExamEntity;
import com.apollogix.exam.modules.user_exam.service.ITeacherUserExamService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TeacherUserExamService extends UserExamService implements ITeacherUserExamService {
    protected TeacherUserExamService(PagingAndSortingRepository<UserExamEntity, UUID> repository, @Qualifier("teacherExamService") IExamService iExamService, @Qualifier("userService") IUserService iUserService) {
        super(repository, iExamService, iUserService);
    }
}
