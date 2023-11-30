package com.dan.restone.challenges.relantionships_challenge.controllers;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.ProjectDTO;
import com.dan.restone.challenges.relantionships_challenge.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO){
        return ResponseEntity.ok(projectService.createProject(projectDTO));
    }


}
