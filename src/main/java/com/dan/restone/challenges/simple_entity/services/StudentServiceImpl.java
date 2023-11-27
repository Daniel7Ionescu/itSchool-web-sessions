package com.dan.restone.challenges.simple_entity.services;

import com.dan.restone.challenges.simple_entity.models.dtos.StudentDTO;
import com.dan.restone.challenges.simple_entity.models.entities.Student;
import com.dan.restone.challenges.simple_entity.repositories.StudentRepository;
import com.dan.restone.challenges.simple_entity.exceptions.StudentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student studentEntity = convertToEntity(studentDTO);

        Long utilDate = new java.util.Date().getTime();
        studentEntity.setRegistrationDate(new Date(utilDate));

        Student savedStudent = studentRepository.save(studentEntity);
        log.info("Saved student {}", savedStudent.getFirstName());
        StudentDTO studentDTOResponse = convertToDTO(savedStudent);

        return studentDTOResponse;
    }

    @Override
    public StudentDTO getStudent(Long id) throws StudentNotFoundException {
        Student studentEntity = studentRepository.findByStudentId(id);

        if (studentEntity == null) {
            //log error
            throw new StudentNotFoundException("User with id: " + id + " not found");
        }

        log.info("Found student {}", studentEntity.getFirstName()  + ", id: " + studentEntity.getStudentId());
        StudentDTO studentDTOResponse = convertToDTO(studentEntity);

        return studentDTOResponse;
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) throws StudentNotFoundException {
        Student studentEntity = studentRepository.findByStudentId(id);
        if (studentEntity == null) throw new StudentNotFoundException("User with id: " + id + " not found");
        log.info("Found student {} to update", studentEntity.getFirstName() + ", id: " + studentEntity.getStudentId());

        updateEntity(studentEntity, studentDTO);
        Student updatedStudent = studentRepository.save(studentEntity);

        return convertToDTO(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) throws StudentNotFoundException {
        Student studentEntity = studentRepository.findByStudentId(id);
        if (studentEntity == null) throw new StudentNotFoundException("User with id: " + id + " not found");
        log.info("Found student {} to delete", studentEntity.getFirstName() + ", id: " + studentEntity.getStudentId());

        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        return studentList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsByAge(int age) {
        List<Student> studentList = studentRepository.findByAgeGreaterThan(age);

        return studentList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private StudentDTO convertToDTO(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }

    private void updateEntity(Student student, StudentDTO studentDTO){
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
    }
}
