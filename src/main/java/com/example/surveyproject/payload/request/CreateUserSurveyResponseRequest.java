package com.example.surveyproject.payload.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserSurveyResponseRequest {
    private String userId;

    private List<String> surveyId;
}
