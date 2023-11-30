package com.dan.restone.practice.jpa_hibernate.services;

import com.dan.restone.practice.jpa_hibernate.models.entities.Weather;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService{

    private final WeatherValidatorService weatherValidatorService;
    private final ObjectMapper objectMapper;

    public WeatherServiceImpl(WeatherValidatorService weatherValidatorService, ObjectMapper objectMapper) {
        this.weatherValidatorService = weatherValidatorService;
        this.objectMapper = objectMapper;
    }

    @Override
    public Weather getWeather(String city) throws IOException {
        weatherValidatorService.validateCity(city);

        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.weatherapi.com/v1/current.json?key=c95443508af34df68be161532231011&q=" + city).build();

        Response response = httpClient.newCall(request).execute();

        String responseBody = response.body().string();

        JsonNode jsonNode = objectMapper.readTree(responseBody);
        System.out.println(responseBody);

        String cityName = jsonNode.get("location").get("name").asText();
        String desc = jsonNode.get("current").get("condition").get("text").asText();
        String lastUpdated = jsonNode.get("current").get("last_updated").asText();

        //"2023-11-10 20:30"
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime lastUpdate = LocalDateTime.parse(lastUpdated, format);

        Weather weather = new Weather();
        weather.setCity(cityName);
        weather.setDescription(desc);
        weather.setLastUpdate(lastUpdate);

        return weather;
    }
}
