package com.example.surveyproject.payload.request;


import com.example.surveyproject.models.Question;
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
public class CreatePostRequest {
    @Id
    private String id;

    @NotBlank
    private String surveyName;

    private List<Question> questions;
}