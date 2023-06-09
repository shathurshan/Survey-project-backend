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
public class Answers {
    @Id
    private long id;

    @NotBlank
    private String answer;
}