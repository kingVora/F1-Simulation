package com.f1.sim.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "Laps")
public class Lap {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_number", referencedColumnName = "driver_number", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_key", referencedColumnName = "session_key", nullable = false)
    private Session session;

    @Column(name = "lap_number", nullable = false)
    private Integer lapNumber;

    @Column(name = "lap_duration")
    private Double lapDuration;

    @Column(name = "duration_sector_1")
    private Double durationSector1;

    @Column(name = "duration_sector_2")
    private Double durationSector2;

    @Column(name = "duration_sector_3")
    private Double durationSector3;

    @Column(name = "i1_speed")
    private Integer i1Speed;

    @Column(name = "i2_speed")
    private Integer i2Speed;

    @Column(name = "st_speed")
    private Integer stSpeed;

    @Column(name = "is_pit_out_lap")
    private Boolean isPitOutLap;

    @Column(name = "date_start")
    private OffsetDateTime dateStart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(Integer lapNumber) {
        this.lapNumber = lapNumber;
    }

    public Double getLapDuration() {
        return lapDuration;
    }

    public void setLapDuration(Double lapDuration) {
        this.lapDuration = lapDuration;
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

    public Integer getStSpeed() {
        return stSpeed;
    }

    public void setStSpeed(Integer stSpeed) {
        this.stSpeed = stSpeed;
    }

    public Boolean getPitOutLap() {
        return isPitOutLap;
    }

    public void setPitOutLap(Boolean pitOutLap) {
        isPitOutLap = pitOutLap;
    }

    public OffsetDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(OffsetDateTime dateStart) {
        this.dateStart = dateStart;
    }

    @Override
    public String toString() {
        return "Laps{" +
                "id=" + id +
                ", driver=" + driver +
                ", session=" + session +
                ", lapNumber=" + lapNumber +
                ", lapDuration=" + lapDuration +
                ", durationSector1=" + durationSector1 +
                ", durationSector2=" + durationSector2 +
                ", durationSector3=" + durationSector3 +
                ", i1Speed=" + i1Speed +
                ", i2Speed=" + i2Speed +
                ", stSpeed=" + stSpeed +
                ", isPitOutLap=" + isPitOutLap +
                ", dateStart=" + dateStart +
                '}';
    }
}
