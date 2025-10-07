package com.f1.sim.service;

import com.f1.sim.dto.DriverDTO;
import com.f1.sim.dto.ResultDTO;
import com.f1.sim.dto.SessionDTO;
import com.f1.sim.dto.WeatherDTO;
import com.f1.sim.models.*;
import com.f1.sim.repository.*;
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

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private QualifyingRepository qualifyingRepository;

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

    public void addResultData(List<ResultDTO> resultDTOS){
        resultDTOS.forEach(System.out::println);
        for(ResultDTO resultDTO : resultDTOS){
            Result result = getResult(resultDTO);
            System.out.println(result);
        }
    }

    public void addWeatherData(List<WeatherDTO> weatherDTOs) {
//        weatherDTOs.forEach(System.out::println);
//        List<Weather> weather = new ArrayList<>();
//        for(WeatherDTO weatherDTO: weatherDTOs){
//            Weather weather1 = getWeather(weatherDTO);
//            System.out.println(weather1);
//        }
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

    private Result getResult(ResultDTO resultDTO){
        System.out.println("Driver number: " + resultDTO.getDriverNumber());
        Driver driver = driverRepository.findByDriverNumber(resultDTO.getDriverNumber());
        if(driver == null)
            return null;
        Result result = new Result();
        result.setPosition(resultDTO.getPosition());
        result.setNumberOfLaps(resultDTO.getNumberOfLaps());
        result.setPoints(resultDTO.getPoints());
        result.setDnf(resultDTO.getDnf());
        result.setDns(resultDTO.getDns());
        result.setDsq(resultDTO.getDsq());

        Session session = sessionRepository.findBySessionKey(resultDTO.getSessionKey());
        result.setSession(session);

        result.setDriver(driver);

        Team team = teamRepository.findByTeamName(driver.getTeam());
        result.setTeam(team);

        List<QualifyingDuration> qdList = new ArrayList<>();
        if(resultDTO.getDuration() instanceof List<?> durations && resultDTO.getGapToLeader() instanceof List<?> gaps){
            int segment = 1;
            for(int i=0; i<durations.size(); i++){
                QualifyingDuration qd = new QualifyingDuration();
                qd.setSegmentNumber(segment++);

                Object d =durations.get(i);
                qd.setDuration(getDurationOrGap(d));

                if(i<gaps.size()){
                    Object g = gaps.get(i);
                    System.out.println("Gap: " + g);
                    qd.setGapToLeader(getDurationOrGap(g));
                } else {
                    qd.setGapToLeader(null);
                }
                qd.setResult(result);
                System.out.println("-----------------");
                System.out.println(qd);
                qdList.add(qd);
            }
        } else {
            Object d = resultDTO.getDuration();
            Object g = resultDTO.getGapToLeader();
            result.setDuration(getDurationOrGap(d));
            result.setGapToLeader(getDurationOrGap(g));
        }
        resultRepository.save(result);
        if(!qdList.isEmpty())
            qualifyingRepository.saveAll(qdList);
        return result;
    }

    private Double getDurationOrGap(Object val){
        if (val instanceof Number){
            return ((Number) val).doubleValue();
        } else {
            return null;
        }
    }

//    private Weather getWeather(WeatherDTO weatherDTO){
//        Weather weather = new Weather();

//        weather.setAirTemperature(dto.getAirTemperature());
//        weather.setRecordedAt(OffsetDateTime.parse(dto.getDate(), ISO_FORMATTER));
//        weather.setHumidity(dto.getHumidity());
//        weather.setPressure(dto.getPressure());
//        weather.setRainfall(dto.getRainfall());
//        weather.setTrackTemperature(dto.getTrackTemperature());
//        weather.setWindDirection(dto.getWindDirection());
//        weather.setWindSpeed(dto.getWindSpeed());
//        weather.setMeetingKey(dto.getMeetingKey());
//    }
}
