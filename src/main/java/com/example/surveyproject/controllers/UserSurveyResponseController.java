package com.example.surveyproject.controllers;


import com.example.surveyproject.models.UserSurveyResponses;
import com.example.surveyproject.payload.request.CreateUserSurveyResponseRequest;
import com.example.surveyproject.payload.response.MessageResponse;
import com.example.surveyproject.repository.UserSurveyResponseRepository;
import com.example.surveyproject.services.UserSurveyResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/userSurveyResponse")
public class UserSurveyResponseController {

    @Autowired
    UserSurveyResponseRepository surveyResponseRepository;

    @Autowired
    UserSurveyResponseService userSurveyResponseService;
    @PostMapping("/create")
    public ResponseEntity<?> createUserSurveyResponse(@Valid @RequestBody CreateUserSurveyResponseRequest createUserSurveyResponseRequest){
        try {
            List<String> surveyIds =  createUserSurveyResponseRequest.getSurveyId();
            //create new post
            UserSurveyResponses userSurveyResponses = new UserSurveyResponses(createUserSurveyResponseRequest.getUserId(),surveyIds);
            surveyResponseRepository.save(userSurveyResponses);
            return ResponseEntity.ok(new MessageResponse("The Response is Submitted Successfully!"));
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("The Post is have some issues to Submit");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserSurveyResponses>> getAllPosts(){
        return ResponseEntity.ok().body(userSurveyResponseService.getAllUserResponseSurveys());
    }
}
