package com.tms.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data @AllArgsConstructor @NoArgsConstructor
public class UserLoginDTO {


    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 50)
    private String userName;

    @Column(nullable = false)
    @NotNull
    @Size(min = 6)
    private String password;
    
//    @Column(nullable = false)
//    @NotNull
//    private String role;

    @Column(nullable = false, unique = true)
    @NotNull
    @Email(message = "must be in the form of a email")
    private String email;
}
