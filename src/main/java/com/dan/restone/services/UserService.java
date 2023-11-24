package com.dan.restone.services;

import com.dan.restone.models.dtos.UserDTO;
import com.dan.restone.models.entities.User;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
}
