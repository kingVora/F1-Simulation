package com.f1.sim.service;

import com.f1.sim.dto.DriverDTO;
import com.f1.sim.dto.SessionDTO;
import com.f1.sim.models.Session;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class OpenF1Client {

    private static final String OPENF1_URL = "https://api.openf1.org/v1";

    private final RestTemplate restTemplate;

    public OpenF1Client(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }

    public List<DriverDTO> fetchDrivers(){
        String url = OPENF1_URL + "/drivers";
        ResponseEntity<DriverDTO[]> response = restTemplate.getForEntity(url,DriverDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<SessionDTO> fetchSessions(){
        String url = OPENF1_URL + "/sessions";
        ResponseEntity<SessionDTO[]> response = restTemplate.getForEntity(url,SessionDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }



}
