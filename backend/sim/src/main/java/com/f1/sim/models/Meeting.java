package com.f1.sim.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;

@Entity
@Table(name = "meetings")
public class Meeting {

    @Id
    @Column(name = "meeting_key")
    private Integer meetingKey;

    @Column(name = "meeting_name", nullable = false)
    private String meetingName;

    @Column(name = "meeting_official_name")
    private String meetingOfficialName;

    @Column(name = "year")
    private Integer year;

    @Column(name = "circuit_key")
    private Integer circuitKey;

    @Column(name = "circuit_short_name")
    private String circuitShortName;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_key")
    private Integer countryKey;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "date_start")
    private OffsetDateTime dateStart;

    @Column(name = "gmt_offset")
    private String gmtOffset;

    @Column(name = "location")
    private String location;

    public Integer getMeetingKey() {
        return meetingKey;
    }

    public void setMeetingKey(Integer meetingKey) {
        this.meetingKey = meetingKey;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getMeetingOfficialName() {
        return meetingOfficialName;
    }

    public void setMeetingOfficialName(String meetingOfficialName) {
        this.meetingOfficialName = meetingOfficialName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getCountryKey() {
        return countryKey;
    }

    public void setCountryKey(Integer countryKey) {
        this.countryKey = countryKey;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public OffsetDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(OffsetDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public String getGmtOffset() {
        return gmtOffset;
    }

    public void setGmtOffset(String gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingKey=" + meetingKey +
                ", meetingName='" + meetingName + '\'' +
                ", meetingOfficialName='" + meetingOfficialName + '\'' +
                ", year=" + year +
                ", circuitKey=" + circuitKey +
                ", circuitShortName='" + circuitShortName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryKey=" + countryKey +
                ", countryName='" + countryName + '\'' +
                ", dateStart=" + dateStart +
                ", gmtOffset='" + gmtOffset + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
