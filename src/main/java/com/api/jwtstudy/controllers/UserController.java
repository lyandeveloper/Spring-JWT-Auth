package com.api.jwtstudy.controllers;

import com.api.jwtstudy.domain.user.User;
import com.api.jwtstudy.dtos.RegisterRequestDTO;
import com.api.jwtstudy.infra.security.UserService;
import com.api.jwtstudy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository repository;
    @PostMapping()
    public ResponseEntity save(@RequestBody RegisterRequestDTO body) {
        Optional<User> user = this.repository.findByEmail(body.email());
        if(!user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        userService.save(body);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("sucesso!");
    }
}
