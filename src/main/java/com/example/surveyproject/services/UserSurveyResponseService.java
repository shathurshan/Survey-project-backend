package com.example.surveyproject.services;


import com.example.surveyproject.models.UserSurveyResponses;
import com.example.surveyproject.repository.UserSurveyResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSurveyResponseService {

    @Autowired
    UserSurveyResponseRepository userSurveyResponseRepository;

    public List<UserSurveyResponses> getAllUserResponseSurveys() {
        return this.userSurveyResponseRepository.findAll();
    }
}
