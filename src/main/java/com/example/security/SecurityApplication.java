package com.example.security;

import com.example.security.domain.User;
import com.example.security.domain.enums.Profile;
import com.example.security.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

    @Autowired
    private IUserService userService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Set<Profile> profs = new HashSet<>();
        profs.add(Profile.ADMIN);
        User u1 = new User(null, "rafu@mail.com", encoder.encode("12345"), profs);
        this.userService.sabe(u1);
    }
}
