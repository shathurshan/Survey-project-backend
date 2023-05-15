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
@Document(collection = "surveys")
public class Surveys {

    @Transient
    public static final String SEQUENCE_NAME = "Survey_sequence";

    @Id
    private String id;

    @NotBlank
    private String surveyName;

    private List<Question> questions;

    public Surveys(String surveyName, List<Question> questions) {
        this.surveyName = surveyName;
        this.questions = questions;
    }
}