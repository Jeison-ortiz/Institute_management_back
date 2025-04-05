package org.projects.msvc_users.service;

import java.util.List;
import java.util.Optional;

import org.projects.msvc_users.entity.UserEntity;

public interface UserService {
    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);
    UserEntity save(UserEntity userEntity);
    UserEntity update(Long id,UserEntity userEntity);
    void delete(Long id);
}
