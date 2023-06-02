package com.example.surveyproject.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usersSurveyResponse")
public class UserSurveyResponses {
    @Id
    private String id;

    private String userId;

    private List<String> surveyIds;

    public UserSurveyResponses(String userId, List<String> surveyIds) {
        this.userId = userId;
        this.surveyIds =  surveyIds;
    }
}
