package com.f1.sim.service;

import com.f1.sim.dto.DriverDTO;
import com.f1.sim.dto.SessionDTO;
import com.f1.sim.models.Driver;
import com.f1.sim.models.Session;
import com.f1.sim.repository.DriverRepository;
import com.f1.sim.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private SessionRepository sessionRepository;

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

    public void addSessionData(List<SessionDTO> sessionDTOS){
        sessionDTOS.forEach(System.out::println);
        List<Session> sessions = new ArrayList<>();
        for(SessionDTO sessionDTO : sessionDTOS){
            if(sessionDTO.getCircuitKey() == null)
                continue;
            Session session = getSession(sessionDTO);
            sessions.add(session);
        }
        sessionRepository.saveAll(sessions);
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

    private Session getSession(SessionDTO sessionDTO){
        Session session = new Session();
        session.setMeetingKey(sessionDTO.getMeetingKey());
        session.setSessionKey(sessionDTO.getSessionKey());
        session.setLocation(sessionDTO.getLocation());
        session.setSessionType(sessionDTO.getSessionType());
        session.setSessionName(sessionDTO.getSessionName());
        session.setCountryKey(sessionDTO.getCountryKey());
        session.setCountryCode(sessionDTO.getCountryCode());
        session.setCountryName(sessionDTO.getCountryName());
        session.setCircuitKey(sessionDTO.getCircuitKey());
        session.setCircuitShortName(sessionDTO.getCircuitShortName());

        session.setDateStart(OffsetDateTime.parse(sessionDTO.getDateStart()));
        session.setDateEnd(OffsetDateTime.parse(sessionDTO.getDateEnd()));
        session.setGmtOffset(sessionDTO.getGmtOffset());
        session.setYear(sessionDTO.getYear());
        session.setResults(new ArrayList<>());
        System.out.println(session);
        return session;
    }
}
