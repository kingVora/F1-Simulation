package com.f1.sim.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StintDTO {

    @JsonProperty("driver_number")
    private Integer driverNumber;

    @JsonProperty("session_key")
    private Integer sessionKey;

    @JsonProperty("meeting_key")
    private Integer meetingKey;

    @JsonProperty("stint_number")
    private Integer stintNumber;

    @JsonProperty("compound")
    private String compound;

    @JsonProperty("lap_start")
    private Integer lapStart;

    @JsonProperty("lap_end")
    private Integer lapEnd;

    @JsonProperty("tyre_age_at_start")
    private Integer tyreAgeAtStart;

    public Integer getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Integer driverNumber) {
        this.driverNumber = driverNumber;
    }

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

    public Integer getStintNumber() {
        return stintNumber;
    }

    public void setStintNumber(Integer stintNumber) {
        this.stintNumber = stintNumber;
    }

    public String getCompound() {
        return compound;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }

    public Integer getLapStart() {
        return lapStart;
    }

    public void setLapStart(Integer lapStart) {
        this.lapStart = lapStart;
    }

    public Integer getLapEnd() {
        return lapEnd;
    }

    public void setLapEnd(Integer lapEnd) {
        this.lapEnd = lapEnd;
    }

    public Integer getTyreAgeAtStart() {
        return tyreAgeAtStart;
    }

    public void setTyreAgeAtStart(Integer tyreAgeAtStart) {
        this.tyreAgeAtStart = tyreAgeAtStart;
    }

    @Override
    public String toString() {
        return "StintDTO{" +
                "driverNumber=" + driverNumber +
                ", sessionKey=" + sessionKey +
                ", meetingKey=" + meetingKey +
                ", stintNumber=" + stintNumber +
                ", compound='" + compound + '\'' +
                ", lapStart=" + lapStart +
                ", lapEnd=" + lapEnd +
                ", tyreAgeAtStart=" + tyreAgeAtStart +
                '}';
    }
}
