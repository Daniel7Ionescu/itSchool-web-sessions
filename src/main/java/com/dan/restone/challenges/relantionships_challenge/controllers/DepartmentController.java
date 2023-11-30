package com.dan.restone.challenges.relantionships_challenge.controllers;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.DepartmentDTO;
import com.dan.restone.challenges.relantionships_challenge.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO){
        return ResponseEntity.ok(departmentService.createDepartment(departmentDTO));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
}
