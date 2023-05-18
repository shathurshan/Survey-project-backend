package com.example.surveyproject.security.services;


import com.example.surveyproject.exception.ResourceNotFoundException;
import com.example.surveyproject.models.SurveyResponse;
import com.example.surveyproject.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SurveyResponseService {

    @Autowired
    ResponseRepository responseRepository;

    public SurveyResponse getSurveysById(String surveyId) {
        Optional<SurveyResponse> surveysDB = this.responseRepository.findById(surveyId);
        if (surveysDB.isPresent()){
            return surveysDB.get();
        } else{
            throw new ResourceNotFoundException("Record not found with id : " + surveyId);
        }
    }

    public List<SurveyResponse> getAllSurveys() {
        return this.responseRepository.findAll();
    }
}
