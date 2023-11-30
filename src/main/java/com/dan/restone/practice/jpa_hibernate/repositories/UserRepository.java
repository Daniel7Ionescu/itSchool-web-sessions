package com.dan.restone.practice.jpa_hibernate.repositories;

import com.dan.restone.practice.jpa_hibernate.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstNameAndOrderAsc(String name);
}
