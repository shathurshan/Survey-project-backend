package com.example.surveyproject.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "surveysResponse")
public class SurveyResponse {

    @Transient
    public static final String SEQUENCE_NAME = "Survey_response_sequence";

    @Id
    private String id;

    @NotBlank
    private String surveyId;

    private List<ResponseQuestion> questions;

    public SurveyResponse(String surveyId, List<ResponseQuestion> questions) {
        this.surveyId = surveyId;
        this.questions = questions;
    }
}
