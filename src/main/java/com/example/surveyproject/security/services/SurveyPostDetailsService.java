package com.example.surveyproject.security.services;


import com.example.surveyproject.exception.ResourceNotFoundException;
import com.example.surveyproject.models.Surveys;
import com.example.surveyproject.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class SurveyPostDetailsService {

    @Autowired
    SurveyRepository surveyRepository;

    public Surveys updateSurveys(Surveys surveys) {
        Optional <Surveys> surveysDB = this.surveyRepository.findById(surveys.getId());
        if (surveysDB.isPresent()) {
            Surveys surveyUpdate = surveysDB.get();
            surveyUpdate.setId(surveys.getId());
            surveyUpdate.setSurveyName(surveys.getSurveyName());
            surveyUpdate.setQuestions(surveys.getQuestions());
           surveyRepository.save(surveyUpdate);
            return surveyUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + surveys.getId());
        }
    }

    public List<Surveys> getAllSurveys() {
        return this.surveyRepository.findAll();
    }



    public Surveys getSurveysById(String surveyId) {
        Optional <Surveys> surveysDB = this.surveyRepository.findById(surveyId);
        if (surveysDB.isPresent()){
            return surveysDB.get();
        } else{
            throw new ResourceNotFoundException("Record not found with id : " + surveyId);
        }
    }

    public void deleteSurvey(String surveyId) {
        Optional <Surveys> surveysDB = this.surveyRepository.findById(surveyId);

        if (surveysDB.isPresent()){
            this.surveyRepository.delete(surveysDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + surveyId);
        }
    }
}