package com.example.surveyproject.models;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    private long id;

    @NotBlank
    private String question;

    private List<Answers> answers;

    public Question(String question, List<Answers> answers){
        this.question = question;
        this.answers = answers;
    }
}