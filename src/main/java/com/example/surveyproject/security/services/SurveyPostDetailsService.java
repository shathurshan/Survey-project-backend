package com.example.surveyproject.security.services;

import com.example.surveyproject.models.Surveys;

import java.util.List;

public interface SurveyPostDetailsService {
    Surveys updateSurveys(Surveys surveys);

    List<Surveys> getAllSurveys();

    Surveys getSurveysById(String surveyId);

    void deleteSurvey(String surveyId);

}