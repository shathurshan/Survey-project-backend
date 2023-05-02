package com.example.surveyproject.payload.response;

import com.example.surveyproject.models.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SurveyPostResponse {
    private String id;
    private String surveyName;
    private List<Question> questions;
}