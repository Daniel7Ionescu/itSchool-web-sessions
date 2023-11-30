package com.dan.restone.challenges.relantionships_challenge.services;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();
}
