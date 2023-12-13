package com.dan.restone.integration_tests;

import com.dan.restone.practice.jpa_hibernate.models.dtos.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@Transactional
@AutoConfigureTestDatabase
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCrateUserShouldPass() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Eric");
        userDTO.setLastName("Cartman");
        userDTO.setEmail("coolEric2@gmail.com");

        MvcResult createUserResult = mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk())
                .andReturn();

        String resultAsString = createUserResult.getResponse().getContentAsString();
        UserDTO userDTOConverted = objectMapper.readValue(resultAsString, UserDTO.class);

        log.info("UserDTO result: " + userDTOConverted);

        assertEquals(userDTO.getFirstName(), userDTOConverted.getFirstName());
        assertEquals(userDTO.getLastName(), userDTOConverted.getLastName());
        assertEquals(userDTO.getEmail(), userDTOConverted.getEmail());
    }

    @Test
    void testCreateUserWithInvalidFirstNameShouldFail() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Er");
        userDTO.setLastName("Cartman");
        userDTO.setEmail("coolEric2@gmail.com");

        MvcResult createUserResult = mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isBadRequest())
                .andReturn();

        String resultAsString = createUserResult.getResponse().getContentAsString();

        assertTrue(resultAsString.contains("Name too short"));
    }
}
