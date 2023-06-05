package com.example.surveyproject.services;


import com.example.surveyproject.exception.ResourceNotFoundException;
import com.example.surveyproject.models.Answers;
import com.example.surveyproject.models.Question;
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
            long QueCounter = 1;
            for (Question each: surveyUpdate.getQuestions()) {
                long ansCounter = 1;
                each.setId(QueCounter);
                QueCounter++;
                for (Answers answer: each.getAnswers()) {
                    answer.setId(ansCounter);
                    ansCounter++;
                }
            }
           surveyRepository.save(surveyUpdate);
            return surveyUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + surveys.getId());
        }
    }

//    public Question updateSurveysQuestion(Question questions, String surveyId) {
//        Optional <Surveys> surveysDB = this.surveyRepository.findById(surveyId);
//        if (surveysDB.isPresent()) {
//            Surveys newSurveys = surveysDB.get();
//            for (Question question: newSurveys.getQuestions()) {
//                if(String.valueOf(question.getId()).equals(questions.getId())){
//                    Question questionUpdate = question;
//                    questionUpdate.setId(questions.getId());
//                    questionUpdate.setId(questions.getId());
//                    questionUpdate.setQuestion(questions.getQuestion());
//                    questionUpdate.setAnswers(question.setAnswers());
//                    surveyRepository.save(newSurveys);
//                    return  question;
//                }  else {
//                    throw new ResourceNotFoundException("Record not found with id : " + questions.getId());
//                }
//            }
//            surveyRepository.save(newSurveys);
//            return questionUpdate;
//        } else {
//            throw new ResourceNotFoundException("Record not found with id : " + questions.getId());
//        }
//    }

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

    public Question getSurveysQuestionsById(String surveyId, String questionId) {
        Optional <Surveys> surveysDB = this.surveyRepository.findById(surveyId);
        if (surveysDB.isPresent()){
            Surveys newSurveys = surveysDB.get();
            for (Question question: newSurveys.getQuestions()) {
                if(String.valueOf(question.getId()).equals(questionId)){
                    return  question;
                }
            }
        } else{
            throw new ResourceNotFoundException("Survey not found with id : " + surveyId);
        }
         throw new ResourceNotFoundException("Question not found with id : " + questionId);
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