package com.dan.restone.challenges.relantionships_challenge.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @OneToOne
    @JoinColumn(name = "laptop_id", referencedColumnName = "id")
    private Laptop laptop;

    //fetch type eager by default
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "employeeInProject")
    List<Project> projects = new ArrayList<>();
}
