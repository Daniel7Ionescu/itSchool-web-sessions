package com.dan.restone.services;

import com.dan.restone.models.Weather;

import java.io.IOException;

public interface WeatherService {

    Weather getWeather(String city) throws IOException;
}
