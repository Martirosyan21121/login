package com.login.login.service;

import com.login.login.model.User;
import com.login.login.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Optional<User> findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
