package com.project.fitness_app.service;

import com.project.fitness_app.dto.RecommendationRequest;
import com.project.fitness_app.model.Activity;
import com.project.fitness_app.model.Recommendation;
import com.project.fitness_app.model.User;
import com.project.fitness_app.repository.ActivityRepository;
import com.project.fitness_app.repository.RecommendationRepository;
import com.project.fitness_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user =  userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found:"+ request.getUserId()));
        Activity activity =activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException(" Activity not found:"+ request.getActivityId()));

        Recommendation recommendation= Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovement())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();
        return recommendationRepository.save(recommendation);
    }
}
