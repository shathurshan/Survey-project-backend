package com.example.surveyproject.repository;

import com.example.surveyproject.models.SurveyResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ResponseRepository extends MongoRepository<SurveyResponse, String> {
    Optional<SurveyResponse> findById(String id);
}
