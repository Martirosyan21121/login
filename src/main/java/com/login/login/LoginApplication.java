package com.login.login;

import com.login.login.model.User;
import com.login.login.model.UserType;
import com.login.login.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepo.findByEmail("admin@admin").isEmpty()) {
            userRepo.save(User.builder()
                    .name("Narek")
                    .surname("Martirosyan")
                    .email("admin@admin")
                    .userType(UserType.ADMIN)
                    .password(passwordEncoder.encode("1111"))
                    .build());
        }
    }

}
