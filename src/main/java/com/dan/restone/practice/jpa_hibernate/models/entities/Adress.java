package com.dan.restone.practice.jpa_hibernate.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "adresses")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
