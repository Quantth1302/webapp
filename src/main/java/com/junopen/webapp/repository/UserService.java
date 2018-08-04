package com.junopen.webapp.repository;

import com.junopen.webapp.model.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();

    Optional<User> findOne(int id);

    void save(User user);

    void delete(int id);
}
