package com.dan.restone.practice.jpa_hibernate.services;

import com.dan.restone.practice.jpa_hibernate.models.dtos.UserDTO;
import com.dan.restone.practice.jpa_hibernate.models.entities.User;
import com.dan.restone.practice.jpa_hibernate.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser(){
        //Given
        User user = new User();
        user.setFirstName("Wendy");
        user.setLastName("Testaburger");
        user.setEmail("wittyWendy@gmail.com");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setFirstName("Wendy");
        savedUser.setLastName("Testaburger");
        savedUser.setEmail("wittyWendy@gmail.com");

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setFirstName("Wendy");
        userDTO.setLastName("Testaburger");
        userDTO.setEmail("wittyWendy@gmail.com");

        when(userRepository.save(user)).thenReturn(savedUser);

        //When
        UserDTO savedUserDTO = userService.createUser(userDTO);

        //Then
        verify(userRepository, times(1)).save(user);
        assertEquals(userDTO, savedUserDTO);
    }

}