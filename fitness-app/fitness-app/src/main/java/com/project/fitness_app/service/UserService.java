package com.project.fitness_app.service;

import com.project.fitness_app.dto.RegisterRequest;
import com.project.fitness_app.dto.UserResponse;
import com.project.fitness_app.model.User;
import com.project.fitness_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest request) {

        User user= User.builder()
                        .email(request.getEmail())
                .firstName(request.getFirstName())
                .password(request.getPassword())
                .lastName(request.getLastName())

                .build(); // all fields are by default null
//
//                User user = new User(
//                null,
//                request.getEmail(),
//                request.getPassword(),
//                request.getFirstName(),
//                request.getLastName(),
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


        User savedUser=userRepository.save(user);

        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User savedUser) {
     UserResponse response= new UserResponse();
     response.setId(savedUser.getId());
     response.setEmail(savedUser.getEmail());
//     response.setPassword(savedUser.getPassword());
     response.setFirstName(savedUser.getFirstName());
     response.setLastName(savedUser.getLastName());
     response.setCreatedAt(savedUser.getCreatedAt());
     response.setUpdatedAt(savedUser.getUpdatedAt());
     return response;
    }
}
