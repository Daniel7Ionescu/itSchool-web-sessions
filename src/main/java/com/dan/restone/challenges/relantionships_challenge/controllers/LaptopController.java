package com.dan.restone.challenges.relantionships_challenge.controllers;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.LaptopDTO;
import com.dan.restone.challenges.relantionships_challenge.services.LaptopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping
    public ResponseEntity<LaptopDTO> createLaptop(@RequestBody LaptopDTO laptopDTO){
        return ResponseEntity.ok(laptopService.createLaptop(laptopDTO));
    }

    @GetMapping
    public ResponseEntity<List<LaptopDTO>> getAllLaptops(){
        return ResponseEntity.ok(laptopService.getAllLaptops());
    }
}
