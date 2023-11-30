package com.dan.restone.challenges.relantionships_challenge.services;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.LaptopDTO;
import com.dan.restone.challenges.relantionships_challenge.models.entities.Laptop;
import com.dan.restone.challenges.relantionships_challenge.repositories.LaptopRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService{

    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LaptopDTO createLaptop(LaptopDTO laptopDTO) {
        Laptop laptop = modelMapper.map(laptopDTO, Laptop.class);
        Laptop savedLaptop = laptopRepository.save(laptop);

        return modelMapper.map(savedLaptop, LaptopDTO.class);
    }

    @Override
    public List<LaptopDTO> getAllLaptops() {
        return laptopRepository.findAll().stream()
                .map(laptop -> modelMapper.map(laptop, LaptopDTO.class))
                .toList();
    }

}
