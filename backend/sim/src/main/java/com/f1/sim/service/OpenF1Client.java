package com.f1.sim.service;

import com.f1.sim.dto.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class OpenF1Client {

    private static final String OPENF1_BASE_URL = "https://api.openf1.org/v1";

    private final RestTemplate restTemplate;

    public OpenF1Client(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }

    public List<DriverDTO> fetchDrivers(){
        String url = OPENF1_BASE_URL + "/drivers";
        ResponseEntity<DriverDTO[]> response = restTemplate.getForEntity(url,DriverDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<SessionDTO> fetchSessions(){
        String url = OPENF1_BASE_URL + "/sessions";
        ResponseEntity<SessionDTO[]> response = restTemplate.getForEntity(url,SessionDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<ResultDTO> fetchResults(Integer sessionKey){
        String url = OPENF1_BASE_URL + "/session_result?session_key=" + sessionKey;
        ResponseEntity<ResultDTO[]> response = restTemplate.getForEntity(url, ResultDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<WeatherDTO> fetchWeather(Integer sessionKey){
        String url = OPENF1_BASE_URL + "/weather?session_key=" + sessionKey;
        ResponseEntity<WeatherDTO[]> response = restTemplate.getForEntity(url, WeatherDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<StintDTO> fetchStints(){
        String url = OPENF1_BASE_URL + "/stints";
        ResponseEntity<StintDTO[]> response = restTemplate.getForEntity(url, StintDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<LapDTO> fetchLaps(Integer sessionKey){
        String url =  OPENF1_BASE_URL + "/laps?session_key=" + sessionKey;
        ResponseEntity<LapDTO[]> response = restTemplate.getForEntity(url,LapDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<MeetingDTO> fetchMeetings(){
        String url = OPENF1_BASE_URL + "/meetings";
        ResponseEntity<MeetingDTO[]> response = restTemplate.getForEntity(url,MeetingDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<PositionDTO> fetchPositions(Integer sessionKey){
        String url =  OPENF1_BASE_URL + "/position?session_key=" + sessionKey;
        ResponseEntity<PositionDTO[]> response = restTemplate.getForEntity(url,PositionDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
