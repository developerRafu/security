package com.example.security.services;

import com.example.security.domain.User;
import com.example.security.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> userFound = this.userService.findByEmail(email);

        if (userFound.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(userFound.get().getId(), userFound.get().getEmail(), userFound.get().getPassword(), userFound.get().getProfiles());
    }


}
