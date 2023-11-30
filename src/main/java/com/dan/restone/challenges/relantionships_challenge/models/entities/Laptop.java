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

    @Column(name = "free")
    private boolean free;



    @OneToOne(mappedBy = "laptop")
    private Employee employee;

}
