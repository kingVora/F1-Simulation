package com.f1.sim.controller;

import com.f1.sim.dto.DriverDTO;
import com.f1.sim.dto.ResultDTO;
import com.f1.sim.dto.SessionDTO;
import com.f1.sim.dto.WeatherDTO;
import com.f1.sim.models.Session;
import com.f1.sim.repository.SessionRepository;
import com.f1.sim.service.DataService;
import com.f1.sim.service.OpenF1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private OpenF1Client openF1Client;

    @Autowired
    private DataService dataService;

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/drivers")
    public ResponseEntity<String> importDrivers() {
        List<DriverDTO> drivers = openF1Client.fetchDrivers();
        dataService.addDriverData(drivers);
        return ResponseEntity.ok("Drivers imported successfully!");
    }

    @GetMapping("/sessions")
    public ResponseEntity<String> importSessions(){
        List<SessionDTO> sessions = openF1Client.fetchSessions();
        dataService.addSessionData(sessions);
        return ResponseEntity.ok("Sessions imported successfully!");
    }

    @GetMapping("/results")
    public ResponseEntity<String> importResults() {
        List<Session> sessions = sessionRepository.findAll();
        System.out.println("Results");
        for(Session session: sessions){
            System.out.println("Session: " + session.getSessionKey());
            List<ResultDTO> results = openF1Client.fetchResults(session.getSessionKey());
            dataService.addResultData(results);

        }
        return ResponseEntity.ok("Results imported successfully!");
    }

    @GetMapping("/weather")
    public ResponseEntity<String> importWeather(){
        List<WeatherDTO> weather = openF1Client.fetchWeather();
        dataService.addWeatherData(weather);
        return ResponseEntity.ok("Weather data imported successfully!");
    }
}
