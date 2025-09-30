package com.f1.sim.service;

import com.f1.sim.dto.DriverDTO;
import com.f1.sim.models.Driver;
import com.f1.sim.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataService {

    @Autowired
    private DriverRepository driverRepository;

    public void addDriverData(List<DriverDTO> drivers) {
        Set<String> driverNames = new HashSet<>();
        List<Driver> driverList = new ArrayList<>();
        for (DriverDTO driverDTO : drivers) {
            String driverName = driverDTO.getFullName();
            if (!driverNames.contains(driverName) && driverDTO.getHeadshotUrl()!=null) {
                driverNames.add(driverName);
                Driver driver = getDriver(driverDTO);
                driverList.add(driver);
            }
        }
        for(String name: driverNames){
            System.out.println("Name: " + name);
        }
        driverRepository.saveAll(driverList);
    }

    private Driver getDriver(DriverDTO driverDTO) {
        Driver driver = new Driver();
        String firstName = driverDTO.getFirstName();
        String lastName = driverDTO.getLastName();
        String fullName = firstName + " " + lastName;

        driver.setDriverNumber(driverDTO.getDriverNumber());
        driver.setFullName(fullName);
        driver.setBroadcastName(driverDTO.getBroadcastName());
        driver.setCountryCode(driverDTO.getCountryCode());
        driver.setHeadshotUrl(driverDTO.getHeadshotUrl());
        driver.setNameAcronym(driverDTO.getNameAcronym());
        driver.setTeam(driverDTO.getTeamName());
        return driver;
    }
}
