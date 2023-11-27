package com.dan.restone.challenges.simple_entity.models.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.sql.Date;

@Data
public class StudentDTO {

    @Size(min = 3, max = 20, message = "First name must be between 3 and 20 characters.")
    private String firstName;

    @Size(min = 3, max = 20, message = "Last name must be between 3 and 20 characters.")
    private String lastName;

    @Email(message = "invalid email")
    private String email;

    @Min(value = 18, message = "Minimum age is 18 to register.")
    @Max(value = 90)
    private int age;

    private Date registrationDate;
}
