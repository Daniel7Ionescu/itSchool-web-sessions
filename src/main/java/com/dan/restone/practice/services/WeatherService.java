package com.dan.restone.practice.services;

import com.dan.restone.practice.models.entities.Weather;

import java.io.IOException;

public interface WeatherService {

    Weather getWeather(String city) throws IOException;
}
