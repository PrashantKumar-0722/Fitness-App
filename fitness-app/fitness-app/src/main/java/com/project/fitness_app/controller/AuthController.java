package com.project.fitness_app.controller;

import com.project.fitness_app.dto.RegisterRequest;
import com.project.fitness_app.dto.UserResponse;
import com.project.fitness_app.model.User;
import com.project.fitness_app.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor // only final ctor are created
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest){
//        User user = new User(
//                null,
//                registerRequest.getEmail(),
//                registerRequest.getPassword(),
//                registerRequest.getFirstName(),
//                registerRequest.getLastName(),
////               Instant.parse("2025-12-08T14:49:41.208Z")
////                               .atZone(ZoneOffset.UTC)
////                                       .toLocalDateTime(),
////                Instant.parse("2025-12-08T14:49:41.208Z")
////                                .atZone(ZoneOffset.UTC)
////                                        .toLocalDateTime(),
//                null,
//                null,
//                List.of(),
//                List.of()
//
//                );

        return ResponseEntity.ok(userService.register(registerRequest));
    }


}
