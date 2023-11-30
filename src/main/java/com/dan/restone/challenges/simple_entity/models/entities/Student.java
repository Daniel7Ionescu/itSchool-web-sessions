package com.dan.restone.challenges.simple_entity.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

//@Data
//@Entity
//@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;
}
