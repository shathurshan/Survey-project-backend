package com.example.surveyproject.repository;

import com.example.surveyproject.models.Surveys;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SurveyRepository extends MongoRepository<Surveys, String> {
    Optional<Surveys> findBySurveyName(String surveyName);

    Boolean existsBySurveyName(String surveyName);
}