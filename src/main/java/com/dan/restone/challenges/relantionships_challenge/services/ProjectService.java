package com.dan.restone.challenges.relantionships_challenge.services;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.ProjectDTO;
import com.dan.restone.challenges.relantionships_challenge.models.entities.Project;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);

    Project getProject(Long id);

    void updateProject(Project project);
}
