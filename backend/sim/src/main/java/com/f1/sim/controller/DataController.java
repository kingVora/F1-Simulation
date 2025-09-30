package com.f1.sim.controller;

import com.f1.sim.dto.DriverDTO;
import com.f1.sim.models.Driver;
import com.f1.sim.service.DataService;
import com.f1.sim.service.OpenF1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private OpenF1Client openF1Client;

    @Autowired
    private DataService dataService;

    @GetMapping("/drivers")
    public ResponseEntity<String> importDrivers() {
        List<DriverDTO> drivers = openF1Client.fetchDrivers();
        dataService.addDriverData(drivers);
        return ResponseEntity.ok("Drivers imported successfully!");
    }
}
