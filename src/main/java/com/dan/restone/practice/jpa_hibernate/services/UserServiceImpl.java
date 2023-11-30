package com.dan.restone.practice.jpa_hibernate.services;

import com.dan.restone.practice.jpa_hibernate.models.dtos.UserDTO;
import com.dan.restone.practice.jpa_hibernate.models.entities.User;
import com.dan.restone.practice.jpa_hibernate.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //validate DTO
        //convert DTO to entity
        //save entity to db
        //convert savedEntity to DTO

        if(userDTO.getFirstName().length() < 3) {
            throw new IllegalArgumentException("Name too short");
        }

        //convert to entity
        User userEntity = new User();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());

        //save entity to db
        User savedUser = userRepository.save(userEntity);
        log.info("User {} was saved", savedUser.getFirstName());

        //convert savedUser to DTO
        UserDTO userResponseDTO = new UserDTO();
        userResponseDTO.setId(savedUser.getId());
        userResponseDTO.setFirstName(savedUser.getFirstName());
        userResponseDTO.setLastName(savedUser.getLastName());
        userResponseDTO.setEmail(savedUser.getEmail());

        return userResponseDTO;
    }
}
