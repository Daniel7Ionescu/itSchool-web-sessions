package com.dan.restone.challenges.relantionships_challenge.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String name;

    //fetch type lazy by default
    @OneToMany(mappedBy = "department")
    List<Employee> employeeList = new ArrayList<>();
}
