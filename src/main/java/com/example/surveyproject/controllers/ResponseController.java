package com.example.surveyproject.controllers;


import com.example.surveyproject.models.SurveyResponse;
import com.example.surveyproject.payload.request.CreateSurveyResponse;
import com.example.surveyproject.payload.response.MessageResponse;
import com.example.surveyproject.repository.ResponseRepository;
import com.example.surveyproject.services.SequenceGeneratorService;
import com.example.surveyproject.services.SurveyResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/response")
public class ResponseController {

    @Autowired
    ResponseRepository responseRepository;

    @Autowired
    SurveyResponseService surveyResponseService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/create")
    public ResponseEntity<?> createSurveyResponse(@Valid @RequestBody CreateSurveyResponse createSurveyResponse){
        try {
            //create new post
            SurveyResponse surveyResponse = new SurveyResponse(createSurveyResponse.getSurveyId(), createSurveyResponse.getUserId(), createSurveyResponse.getQuestions());
            surveyResponse.setId("SURVEY-RES-" + sequenceGeneratorService.generateSurveyResponseSequence(SurveyResponse.SEQUENCE_NAME));
            responseRepository.save(surveyResponse);

            return ResponseEntity.ok(new MessageResponse("The Post is Submitted Successfully!"));
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("The Post is have some issues to Submit");
        }
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<SurveyResponse> getPostsById(@PathVariable String id){
        return ResponseEntity.ok().body(surveyResponseService.getSurveysById(id));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<SurveyResponse>> getAllPosts(){
        return ResponseEntity.ok().body(surveyResponseService.getAllSurveys());
    }

}
