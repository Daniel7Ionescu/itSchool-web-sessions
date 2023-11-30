package com.dan.restone.challenges.relantionships_challenge.services;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.EmployeeDTO;
import com.dan.restone.challenges.relantionships_challenge.models.dtos.LaptopDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO assignLaptop(Long id);

    EmployeeDTO  assignToProject(Long empId, Long projId);


}
