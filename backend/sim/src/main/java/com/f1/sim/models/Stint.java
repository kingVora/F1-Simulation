package com.f1.sim.models;

import jakarta.persistence.*;

@Entity
@Table(name = "stint")
public class Stint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stint_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_number", referencedColumnName = "driver_number", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_key", referencedColumnName = "session_key", nullable = false)
    private Session session;

    @Column(name = "stint_number", nullable = false)
    private Integer stintNumber;

    @Column(name = "compound", length = 20)
    private String compound;

    @Column(name = "lap_start")
    private Integer lapStart;

    @Column(name = "lap_end")
    private Integer lapEnd;

    @Column(name = "tyre_age_at_start")
    private Integer tyreAgeAtStart;

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
        return "Stint{" +
                "id=" + id +
                ", driver=" + driver +
                ", session=" + session +
                ", stintNumber=" + stintNumber +
                ", compound='" + compound + '\'' +
                ", lapStart=" + lapStart +
                ", lapEnd=" + lapEnd +
                ", tyreAgeAtStart=" + tyreAgeAtStart +
                '}';
    }
}
