package com.dan.restone.controllers;

import com.dan.restone.models.Weather;
import com.dan.restone.services.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather")
    public ResponseEntity<Weather> getWeather(@RequestParam String city) throws IOException {

        return ResponseEntity.ok(weatherService.getWeather(city));
    }
}
