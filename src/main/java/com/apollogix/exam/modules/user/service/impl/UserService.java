package com.apollogix.exam.modules.user.service.impl;

import com.apollogix.exam.modules.common.exception.InvalidException;
import com.apollogix.exam.modules.common.model.IFilter;
import com.apollogix.exam.modules.common.model.response.BasePagingResponse;
import com.apollogix.exam.modules.common.service.BaseDataService;
import com.apollogix.exam.modules.user.entity.UserEntity;
import com.apollogix.exam.modules.user.model.UserDetail;
import com.apollogix.exam.modules.user.model.UserInfo;
import com.apollogix.exam.modules.user.repository.UserRepository;
import com.apollogix.exam.modules.user.service.IUserService;
import com.apollogix.exam.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserService extends BaseDataService<UUID, UserInfo, UserDetail, UserEntity> implements IUserService {
    protected UserService(PagingAndSortingRepository<UserEntity, UUID> repository, UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        super(repository);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return getUserByEmail(username);
        } catch (InvalidException e) {
            throw new UsernameNotFoundException(e.getErrorMessage());
        }
    }

    @Override
    public UserEntity createConvertToEntity(UserDetail detail) throws InvalidException {
        return UserEntity.builder()
                .email(detail.getEmail())
                .password(passwordEncoder.encode(detail.getPassword()))
                .fullName(detail.getFullName())
                .name(detail.getName())
                .phoneNumber(detail.getPhoneNumber())
                .userRole(detail.getUserRole())
                .build();
    }

    @Override
    public void updateConvertToEntity(UserEntity entity, UserDetail detail) throws InvalidException {

    }

    @Override
    public UserDetail convertToDetail(UserEntity entity) throws InvalidException {
        return UserDetail.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .username(entity.getEmail())
                .fullName(entity.getFullName())
                .password(entity.getPassword())
                .phoneNumber(entity.getPhoneNumber())
                .name(entity.getName())
                .userRole(entity.getUserRole())
                .authorities(AuthorityUtils.createAuthorityList(entity.getUserRole()))
                .createdDate(TimeUtil.toTimeStamp(entity.getCreatedDate()))
                .lastModifiedDate(TimeUtil.toTimeStamp(entity.getLastModifiedDate()))
                .lastModifiedBy(entity.getLastModifiedBy())
                .createdBy(entity.getCreatedBy())
                .build();
    }

    @Override
    public UserInfo convertToInfo(UserEntity entity) throws InvalidException {
        return null;
    }

    @Override
    public UserDetail getUserByEmail(String email) throws InvalidException {
        Optional<UserEntity> userEntity = userRepository.findFirstByEmail(email);
        if (userEntity.isPresent()) {
            return convertToDetail(userEntity.get());
        }
        return null;
    }

    @Override
    public UserEntity getEntity(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    protected <F extends IFilter> UserDetail aroundGetDetail(UUID id, F filter) throws InvalidException {
        return null;
    }

    @Override
    protected <F extends IFilter> BasePagingResponse<UserInfo> postGetPage(F filter, Integer number, Integer size) throws InvalidException {
        return null;
    }
}
