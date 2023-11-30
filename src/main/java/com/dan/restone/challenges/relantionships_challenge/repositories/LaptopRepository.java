package com.dan.restone.challenges.relantionships_challenge.repositories;

import com.dan.restone.challenges.relantionships_challenge.models.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    Laptop findFirstByFreeTrue();
}
