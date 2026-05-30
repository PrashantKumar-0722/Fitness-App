package com.project.fitness_app.controller;

import com.project.fitness_app.dto.RecommendationRequest;
import com.project.fitness_app.model.Recommendation;
import com.project.fitness_app.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody RecommendationRequest request
            ){
        Recommendation recommendation=recommendationService.generateRecommendation(request);
        return  ResponseEntity.ok(recommendation);

    }
}
