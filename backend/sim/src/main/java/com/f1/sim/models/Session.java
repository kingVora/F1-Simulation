package com.f1.sim.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @Column(name = "session_key")
    private Integer sessionKey;

    @Column(name = "meeting_key")
    private Integer meetingKey;

    @Column(name = "circuit_key")
    private Integer circuitKey;

    @Column(name = "circuit_short_name", length = 100)
    private String circuitShortName;

    @Column(name = "country_key")
    private Integer countryKey;

    @Column(name = "country_code", length = 10)
    private String countryCode;

    @Column(name = "country_name", length = 100)
    private String countryName;

    @Column(name = "location", length = 150)
    private String location;

    @Column(name = "session_name", length = 100)
    private String sessionName;

    @Column(name = "session_type", length = 50)
    private String sessionType;

    @Column(name = "date_start")
    private OffsetDateTime dateStart;

    @Column(name = "date_end")
    private OffsetDateTime dateEnd;

    @Column(name = "gmt_offset", length = 20)
    private String gmtOffset;

    @Column(name = "year")
    private Integer year;

    //mappedBy = "points to the field in the child entity that owns the foreign key".
    //No column called results will be created. Now each session can retrieve all associated result rows.
    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
    private List<Result> results;

    public Integer getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(Integer sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Integer getMeetingKey() {
        return meetingKey;
    }

    public void setMeetingKey(Integer meetingKey) {
        this.meetingKey = meetingKey;
    }

    public Integer getCircuitKey() {
        return circuitKey;
    }

    public void setCircuitKey(Integer circuitKey) {
        this.circuitKey = circuitKey;
    }

    public String getCircuitShortName() {
        return circuitShortName;
    }

    public void setCircuitShortName(String circuitShortName) {
        this.circuitShortName = circuitShortName;
    }

    public Integer getCountryKey() {
        return countryKey;
    }

    public void setCountryKey(Integer countryKey) {
        this.countryKey = countryKey;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public OffsetDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(OffsetDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public OffsetDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(OffsetDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getGmtOffset() {
        return gmtOffset;
    }

    public void setGmtOffset(String gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionKey=" + sessionKey +
                ", meetingKey=" + meetingKey +
                ", circuitKey=" + circuitKey +
                ", circuitShortName='" + circuitShortName + '\'' +
                ", countryKey=" + countryKey +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", location='" + location + '\'' +
                ", sessionName='" + sessionName + '\'' +
                ", sessionType='" + sessionType + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", gmtOffset='" + gmtOffset + '\'' +
                ", year=" + year +
                ", results=" + results +
                '}';
    }
}
