package com.f1.sim.controller;

import com.f1.sim.dto.*;
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
        for(Session session: sessions){
            List<ResultDTO> results = openF1Client.fetchResults(session.getSessionKey());
            dataService.addResultData(results);

        }
        return ResponseEntity.ok("Results imported successfully!");
    }

    @GetMapping("/weather")
    public ResponseEntity<String> importWeather() throws InterruptedException {
        List<Session> sessions = sessionRepository.findAll();
        for(Session session: sessions){
            Thread.sleep(2000);
            List<WeatherDTO> weather = openF1Client.fetchWeather(session.getSessionKey());
            dataService.addWeatherData(weather);
        }
        return ResponseEntity.ok("Weather data imported successfully!");
    }

    @GetMapping("/stints")
    public ResponseEntity<String> importStint(){
        List<StintDTO> stint = openF1Client.fetchStints();
        dataService.addStintData(stint);
        return ResponseEntity.ok("Stint data imported successfully!");
    }

    @GetMapping("/laps")
    public ResponseEntity<String> importLaps(){
        List<Session> sessions = sessionRepository.findAll();
        for(Session session: sessions){
            List<LapDTO> laps = openF1Client.fetchLaps(session.getSessionKey());
            dataService.addLapData(laps);
        }
        return ResponseEntity.ok("Lap data imported successfully!");
    }

    @GetMapping("/meetings")
    public ResponseEntity<String> importMeetings(){
        List<MeetingDTO> meetings = openF1Client.fetchMeetings();
        dataService.addMeetingData(meetings);
        return ResponseEntity.ok("Meeting data imported successfully!");
    }

    @GetMapping("/positions")
    public ResponseEntity<String> importPositions(){
        List<Session> sessions = sessionRepository.findAll();
        for(Session session: sessions){
            List<PositionDTO> positions = openF1Client.fetchPositions(session.getSessionKey());
            dataService.addPositionData(positions);
        }
        return ResponseEntity.ok("Position data imported successfully!");
    }

}
