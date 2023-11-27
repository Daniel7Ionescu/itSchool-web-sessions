package com.dan.restone.challenges.simple_entity.services;

import com.dan.restone.challenges.simple_entity.models.dtos.StudentDTO;
import com.dan.restone.challenges.simple_entity.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO getStudent(Long id) throws StudentNotFoundException;
    StudentDTO updateStudent(Long id, StudentDTO studentDTO) throws StudentNotFoundException;
    List<StudentDTO> getAllStudents();

    List<StudentDTO> getStudentsByAge(int age);
    void deleteStudent(Long id) throws StudentNotFoundException;


}
