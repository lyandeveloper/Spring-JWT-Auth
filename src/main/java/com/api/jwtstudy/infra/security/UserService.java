package com.api.jwtstudy.infra.security;

import com.api.jwtstudy.domain.user.User;
import com.api.jwtstudy.dtos.RegisterRequestDTO;
import com.api.jwtstudy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void save(RegisterRequestDTO body) {
        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setEmail(body.email());
        newUser.setName(body.name());
        this.userRepository.save(newUser);
    }
}
