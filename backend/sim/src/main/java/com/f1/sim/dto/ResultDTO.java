package com.f1.sim.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultDTO {

    @JsonProperty("position")
    private Integer position;

    @JsonProperty("driver_number")
    private Integer driverNumber;

    @JsonProperty("number_of_laps")
    private Integer numberOfLaps;

    @JsonProperty("points")
    private Integer points;

    @JsonProperty("dnf")
    private Boolean dnf;

    @JsonProperty("dns")
    private Boolean dns;

    @JsonProperty("dsq")
    private Boolean dsq;

    @JsonProperty("duration")
    private Object duration;

    @JsonProperty("gap_to_leader")
    private Object gapToLeader;

    @JsonProperty("meeting_key")
    private Integer meetingKey;

    @JsonProperty("session_key")
    private Integer sessionKey;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Integer driverNumber) {
        this.driverNumber = driverNumber;
    }

    public Integer getNumberOfLaps() {
        return numberOfLaps;
    }

    public void setNumberOfLaps(Integer numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Boolean getDnf() {
        return dnf;
    }

    public void setDnf(Boolean dnf) {
        this.dnf = dnf;
    }

    public Boolean getDns() {
        return dns;
    }

    public void setDns(Boolean dns) {
        this.dns = dns;
    }

    public Boolean getDsq() {
        return dsq;
    }

    public void setDsq(Boolean dsq) {
        this.dsq = dsq;
    }

    public Object getDuration() {
        return duration;
    }

    public void setDuration(Object duration) {
        this.duration = duration;
    }

    public Object getGapToLeader() {
        return gapToLeader;
    }

    public void setGapToLeader(Object gapToLeader) {
        this.gapToLeader = gapToLeader;
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

    @Override
    public String toString() {
        return "ResultDTO{" +
                "position=" + position +
                ", driverNumber=" + driverNumber +
                ", numberOfLaps=" + numberOfLaps +
                ", points=" + points +
                ", dnf=" + dnf +
                ", dns=" + dns +
                ", dsq=" + dsq +
                ", duration=" + duration +
                ", gapToLeader=" + gapToLeader +
                ", meetingKey=" + meetingKey +
                ", sessionKey=" + sessionKey +
                '}';
    }
}
