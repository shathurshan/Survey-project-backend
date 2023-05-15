package com.example.surveyproject.controllers;

import com.example.surveyproject.models.Answers;
import com.example.surveyproject.models.Question;
import com.example.surveyproject.models.Surveys;
import com.example.surveyproject.payload.request.CreatePostRequest;
import com.example.surveyproject.payload.response.MessageResponse;
import com.example.surveyproject.repository.SurveyRepository;
import com.example.surveyproject.security.services.SequenceGeneratorService;
import com.example.surveyproject.security.services.SurveyPostDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/survey")
public class SurveyController {
    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    SurveyPostDetailsService surveyPostDetailsService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@Valid @RequestBody CreatePostRequest createPostRequest){
        try {
            if (surveyRepository.existsBySurveyName(createPostRequest.getSurveyName())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Survey Name is already exist!"));
            }

            List<Question> questions = createPostRequest.getQuestions();
            long QueCounter = 1;
            for (Question each: questions) {
                long ansCounter = 1;
                each.setId(QueCounter);
                QueCounter++;
                for (Answers answer: each.getAnswers()) {
                    answer.setId(ansCounter);
                    ansCounter++;
                }
            }
            //create new post
            Surveys surveys = new Surveys(createPostRequest.getSurveyName(), questions);
            surveys.setId("SURVEY-" + sequenceGeneratorService.generateSurveySequence(Surveys.SEQUENCE_NAME));
            surveyRepository.save(surveys);

            return ResponseEntity.ok(new MessageResponse("The post is created successfully!"));
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("The post not created successfully");
        }
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Surveys>> getAllPosts(){
        return ResponseEntity.ok().body(surveyPostDetailsService.getAllSurveys());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Surveys> getPostsById(@PathVariable String id){
        return ResponseEntity.ok().body(surveyPostDetailsService.getSurveysById(id));
    }

    @PutMapping("/postupdate/{id}")
    public ResponseEntity<Surveys> updatePost(@PathVariable String id, @RequestBody Surveys surveys){
        surveys.setId(id);
        return ResponseEntity.ok().body(surveyPostDetailsService.updateSurveys(surveys));
    }

    @DeleteMapping("/postdelete/{id}")
    public HttpStatus deletePost(@PathVariable String id){
       this.surveyPostDetailsService.deleteSurvey(id);
       return HttpStatus.OK;
    }
}


