package com.example.surveyproject.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseQuestion {
    @Id
    private long id;

    @NotBlank
    private String question;

    private String answer;

    public ResponseQuestion(String question, String answers){
        this.question = question;
        this.answer = answers;
    }
}
