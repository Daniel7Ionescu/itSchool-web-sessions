package com.dan.restone.challenges.relantionships_challenge.services;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.LaptopDTO;
import com.dan.restone.challenges.relantionships_challenge.models.entities.Laptop;

import java.util.List;

public interface LaptopService {

    LaptopDTO createLaptop(LaptopDTO laptopDTO);
    List<LaptopDTO> getAllLaptops();
}
