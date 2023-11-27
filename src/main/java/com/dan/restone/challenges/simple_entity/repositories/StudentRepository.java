package com.dan.restone.challenges.simple_entity.repositories;

import com.dan.restone.challenges.simple_entity.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(Long id);
    List<Student> findByAgeGreaterThan(int age);

}
