package com.f1.sim.service;

import com.f1.sim.dto.*;
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

    private DriverRepository driverRepository;
    private SessionRepository sessionRepository;
    private ResultRepository resultRepository;
    private TeamRepository teamRepository;
    private QualifyingRepository qualifyingRepository;
    private WeatherRepository weatherRepository;
    private StintRepository stintRepository;
    private LapRepository lapRepository;
    private MeetingRepository meetingRepository;
    private PositionRepository positionRepository;

    public DataService(DriverRepository driverRepository, SessionRepository sessionRepository, ResultRepository resultRepository, TeamRepository teamRepository,
                       QualifyingRepository qualifyingRepository, WeatherRepository weatherRepository, StintRepository stintRepository, LapRepository lapRepository, MeetingRepository meetingRepository,
                       PositionRepository positionRepository) {
        this.driverRepository = driverRepository;
        this.sessionRepository = sessionRepository;
        this.resultRepository = resultRepository;
        this.teamRepository = teamRepository;
        this.qualifyingRepository = qualifyingRepository;
        this.weatherRepository = weatherRepository;
        this.stintRepository = stintRepository;
        this.lapRepository = lapRepository;
        this.meetingRepository = meetingRepository;
        this.positionRepository = positionRepository;
    }

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
        weatherDTOs.forEach(System.out::println);
        List<Weather> weather = new ArrayList<>();
        int count = 0;
        for(WeatherDTO weatherDTO: weatherDTOs){
            if(++count%5!=0) continue;
            Weather weather1 = getWeather(weatherDTO);
            System.out.println(weather1);
            weather.add(weather1);
        }
        weatherRepository.saveAll(weather);
    }

    public void addStintData(List<StintDTO> stintDTOs) {
       for(StintDTO stintDTO: stintDTOs){
           Stint stint = getStint(stintDTO);
           System.out.println(stint);
       }
    }

    public void addLapData(List<LapDTO> lapDTOS){
        for(LapDTO lapDTO: lapDTOS){
            Lap lap = getLap(lapDTO);
            System.out.println(lap);
        }
    }

    public void addMeetingData(List<MeetingDTO> meetingDTOS){
        for(MeetingDTO meetingDTO: meetingDTOS){
            getMeeting(meetingDTO);
        }
    }

    public void addPositionData(List<PositionDTO> positionDTOS){
        for(PositionDTO positionDTO: positionDTOS){
            getPosition(positionDTO);
        }
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

    private Weather getWeather(WeatherDTO weatherDTO){
        Weather weather = new Weather();

        weather.setMeetingKey(weatherDTO.getMeetingKey());
        weather.setSessionKey(weatherDTO.getSessionKey());
        weather.setDate(weatherDTO.getDate());
        weather.setAirTemperature(weatherDTO.getAirTemperature());
        weather.setTrackTemperature(weatherDTO.getTrackTemperature());
        weather.setHumidity(weatherDTO.getHumidity());
        weather.setPressure(weatherDTO.getPressure());
        weather.setRainfall(weatherDTO.getRainfall());
        weather.setWindSpeed(weatherDTO.getWindSpeed());
        weather.setWindDirection(weatherDTO.getWindDirection());

        return weather;
    }

    private Stint getStint(StintDTO stintDTO) {
        Driver driver = driverRepository.findByDriverNumber(stintDTO.getDriverNumber());
        Session session = sessionRepository.findBySessionKey(stintDTO.getSessionKey());
        if(driver == null || session==null)
            return null;

        Stint stint = new Stint();

        stint.setStintNumber(stintDTO.getStintNumber());
        stint.setCompound(stintDTO.getCompound());
        stint.setLapStart(stintDTO.getLapStart());
        stint.setLapEnd(stintDTO.getLapEnd());
        stint.setTyreAgeAtStart(stintDTO.getTyreAgeAtStart());
        stint.setDriver(driver);
        stint.setSession(session);

        stintRepository.save(stint);
        return stint;
    }

    private Lap getLap(LapDTO lapDTO){
        Driver driver = driverRepository.findByDriverNumber(lapDTO.getDriverNumber());
        if(driver == null)
            return null;

        Lap lap = new Lap();

        lap.setDriver(driver);
        lap.setLapNumber(lapDTO.getLapNumber());
        lap.setLapDuration(lapDTO.getLapDuration());
        lap.setDurationSector1(lapDTO.getDurationSector1());
        lap.setDurationSector2(lapDTO.getDurationSector2());
        lap.setDurationSector3(lapDTO.getDurationSector3());
        lap.setI1Speed(lapDTO.getI1Speed());
        lap.setI2Speed(lapDTO.getI2Speed());
        lap.setStSpeed(lapDTO.getStSpeed());
        lap.setPitOutLap(lapDTO.getPitOutLap());
        lap.setDateStart(lapDTO.getDateStart());

        Session session = sessionRepository.findBySessionKey(lapDTO.getSessionKey());
        lap.setSession(session);

        lapRepository.save(lap);
        return lap;
    }

    private void getMeeting(MeetingDTO dto){
        Meeting meeting = new Meeting();

        meeting.setMeetingKey(dto.getMeetingKey());
        meeting.setMeetingName(dto.getMeetingName());
        meeting.setMeetingOfficialName(dto.getMeetingOfficialName());
        meeting.setYear(dto.getYear());
        meeting.setCircuitKey(dto.getCircuitKey());
        meeting.setCircuitShortName(dto.getCircuitShortName());
        meeting.setCountryCode(dto.getCountryCode());
        meeting.setCountryKey(dto.getCountryKey());
        meeting.setCountryName(dto.getCountryName());
        meeting.setDateStart(dto.getDateStart());
        meeting.setGmtOffset(dto.getGmtOffset());
        meeting.setLocation(dto.getLocation());

        System.out.println(meeting);
        meetingRepository.save(meeting);

    }

    private void getPosition(PositionDTO dto){
        Position position = new Position();

        Driver driver = driverRepository.findByDriverNumber(dto.getDriverNumber());
        if(driver == null)
            return;

        position.setDate(dto.getDate());
        position.setDriverNumber(dto.getDriverNumber());
        position.setMeetingKey(dto.getMeetingKey());
        position.setPosition(dto.getPosition());
        position.setSessionKey(dto.getSessionKey());

        System.out.println(position);
        positionRepository.save(position);
    }

}
