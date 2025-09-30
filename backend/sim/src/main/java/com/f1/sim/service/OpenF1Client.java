package com.f1.sim.service;

import com.f1.sim.dto.DriverDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OpenF1Client {

    private static final String OPENF1_DRIVERS_URL = "https://api.openf1.org/v1/drivers";

    private final RestTemplate restTemplate;

    public OpenF1Client(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }

    public List<DriverDTO> fetchDrivers(){
        ResponseEntity<DriverDTO[]> response = restTemplate.getForEntity(OPENF1_DRIVERS_URL,DriverDTO[].class);
        return Arrays.asList(response.getBody());
    }

}
