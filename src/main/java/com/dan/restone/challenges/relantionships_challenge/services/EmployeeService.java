package com.dan.restone.challenges.relantionships_challenge.services;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployee(Long id);

    EmployeeDTO assignLaptop(Long id);
}
