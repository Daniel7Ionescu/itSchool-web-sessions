package com.dan.restone.practice.jpa_hibernate.models.dtos;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
