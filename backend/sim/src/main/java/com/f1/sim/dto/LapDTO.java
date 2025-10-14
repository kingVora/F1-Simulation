package com.f1.sim.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class LapDTO {

    @JsonProperty("driver_number")
    private Integer driverNumber;

    @JsonProperty("duration_sector_1")
    private Double durationSector1;

    @JsonProperty("duration_sector_2")
    private Double durationSector2;

    @JsonProperty("duration_sector_3")
    private Double durationSector3;

    @JsonProperty("i1_speed")
    private Integer i1Speed;

    @JsonProperty("i2_speed")
    private Integer i2Speed;

    @JsonProperty("is_pit_out_lap")
    private Boolean isPitOutLap;

    @JsonProperty("lap_duration")
    private Double lapDuration;

    @JsonProperty("lap_number")
    private Integer lapNumber;

    @JsonProperty("meeting_key")
    private Integer meetingKey;

    @JsonProperty("session_key")
    private Integer sessionKey;

    @JsonProperty("st_speed")
    private Integer stSpeed;

    @JsonProperty("date_start")
    private OffsetDateTime dateStart;

    public Integer getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Integer driverNumber) {
        this.driverNumber = driverNumber;
    }

    public Double getDurationSector1() {
        return durationSector1;
    }

    public void setDurationSector1(Double durationSector1) {
        this.durationSector1 = durationSector1;
    }

    public Double getDurationSector2() {
        return durationSector2;
    }

    public void setDurationSector2(Double durationSector2) {
        this.durationSector2 = durationSector2;
    }

    public Double getDurationSector3() {
        return durationSector3;
    }

    public void setDurationSector3(Double durationSector3) {
        this.durationSector3 = durationSector3;
    }

    public Integer getI1Speed() {
        return i1Speed;
    }

    public void setI1Speed(Integer i1Speed) {
        this.i1Speed = i1Speed;
    }

    public Integer getI2Speed() {
        return i2Speed;
    }

    public void setI2Speed(Integer i2Speed) {
        this.i2Speed = i2Speed;
    }

    public Boolean getPitOutLap() {
        return isPitOutLap;
    }

    public void setPitOutLap(Boolean pitOutLap) {
        isPitOutLap = pitOutLap;
    }

    public Double getLapDuration() {
        return lapDuration;
    }

    public void setLapDuration(Double lapDuration) {
        this.lapDuration = lapDuration;
    }

    public Integer getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(Integer lapNumber) {
        this.lapNumber = lapNumber;
    }

    public Integer getMeetingKey() {
        return meetingKey;
    }

    public void setMeetingKey(Integer meetingKey) {
        this.meetingKey = meetingKey;
    }

    public Integer getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(Integer sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Integer getStSpeed() {
        return stSpeed;
    }

    public void setStSpeed(Integer stSpeed) {
        this.stSpeed = stSpeed;
    }

    public OffsetDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(OffsetDateTime dateStart) {
        this.dateStart = dateStart;
    }

    @Override
    public String toString() {
        return "LapDTO{" +
                "driverNumber=" + driverNumber +
                ", durationSector1=" + durationSector1 +
                ", durationSector2=" + durationSector2 +
                ", durationSector3=" + durationSector3 +
                ", i1Speed=" + i1Speed +
                ", i2Speed=" + i2Speed +
                ", isPitOutLap=" + isPitOutLap +
                ", lapDuration=" + lapDuration +
                ", lapNumber=" + lapNumber +
                ", meetingKey=" + meetingKey +
                ", sessionKey=" + sessionKey +
                ", stSpeed=" + stSpeed +
                ", dateStart=" + dateStart +
                '}';
    }
}
