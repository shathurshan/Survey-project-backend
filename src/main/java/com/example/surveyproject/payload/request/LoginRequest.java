
package com.example.surveyproject.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class LoginRequest {
    @NotNull
    private String username;

    @NotNull
    private String password;
}