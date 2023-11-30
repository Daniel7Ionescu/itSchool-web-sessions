package com.dan.restone.practice.jpa_hibernate.services;

import com.dan.restone.practice.jpa_hibernate.models.dtos.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
}
