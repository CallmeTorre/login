package com.login.login.domain.repository;

import java.util.Optional;

import com.login.login.domain.User;

public interface UserRepository {
    Optional<User> findByUserName(String userName);

    void save(User user);
}
