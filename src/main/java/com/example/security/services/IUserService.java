package com.example.security.services;

import com.example.security.domain.User;
import com.example.security.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    User sabe(User obj);

    Optional<User> findByEmail(String email);

    User findById(Long id);
}
