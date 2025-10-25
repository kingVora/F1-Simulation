package com.f1.sim.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // surrogate key

    @Column(name = "date")
    private OffsetDateTime date;

    @Column(name = "driver_number")
    private Integer driverNumber;

    @Column(name = "meeting_key")
    private Integer meetingKey;

    @Column(name = "position")
    private Integer position;

    @Column(name = "session_key")
    private Integer sessionKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public Integer getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Integer driverNumber) {
        this.driverNumber = driverNumber;
    }

    public Integer getMeetingKey() {
        return meetingKey;
    }

    public void setMeetingKey(Integer meetingKey) {
        this.meetingKey = meetingKey;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(Integer sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", date=" + date +
                ", driverNumber=" + driverNumber +
                ", meetingKey=" + meetingKey +
                ", position=" + position +
                ", sessionKey=" + sessionKey +
                '}';
    }
}
