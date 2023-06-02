package com.example.surveyproject.repository;

import com.example.surveyproject.models.UserSurveyResponses;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserSurveyResponseRepository extends MongoRepository<UserSurveyResponses, String> {
    Optional<UserSurveyResponses> findById(String userId);

    Boolean existsByUserId(String userId);
}
