package com.example.surveyproject.payload.request;

import com.example.surveyproject.models.ResponseQuestion;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSurveyResponse {

    @NotBlank
    private String surveyName;

    private List<ResponseQuestion> questions;
}
