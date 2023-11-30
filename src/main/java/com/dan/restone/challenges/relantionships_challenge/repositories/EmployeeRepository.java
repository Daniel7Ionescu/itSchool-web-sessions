package com.dan.restone.challenges.relantionships_challenge.repositories;

import com.dan.restone.challenges.relantionships_challenge.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
