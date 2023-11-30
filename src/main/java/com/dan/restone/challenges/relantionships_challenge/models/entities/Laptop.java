package com.dan.restone.challenges.relantionships_challenge.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "laptop_name")
    private String name;

    @OneToOne
    private Employee employee;
}
