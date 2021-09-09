package com.example.security.services;

import com.example.security.domain.User;
import com.example.security.domain.enums.Profile;
import com.example.security.repositories.UserRepository;
import com.example.security.security.UserSS;
import com.example.security.services.exceptions.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User sabe(User obj) {
        return this.repository.save(obj);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.repository.findByEamil(email);
    }

    @Override
    public User findById(Long id) {

        UserSS user = UserSSService.authenticated();

        if (user == null && user.hasRole(Profile.ADMIN) && user.getId().equals(id)) {
            throw new AuthException("Acesso negado");
        }
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

}
