package com.dan.restone.challenges.simple_entity.controllers;

import com.dan.restone.challenges.simple_entity.models.dtos.StudentDTO;
import com.dan.restone.challenges.simple_entity.services.StudentService;
import com.dan.restone.challenges.simple_entity.exceptions.StudentNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<StudentDTO>> getStudentsByAge(@RequestParam int age){
        return ResponseEntity.ok(studentService.getStudentsByAge(age));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@Valid @RequestBody StudentDTO studentDTO, @PathVariable Long id) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDTO));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student with id: " + id + " deleted.");
    }


}
