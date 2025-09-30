package com.f1.sim.models;

import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @Column(name = "driver_number")
    private int driverNumber;

    @Column(name = "broadcast_Name")
    private String broadcastName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "name_acronym")
    private String nameAcronym;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "headshot_url")
    private String headshotUrl;

    @Column(name = "team")
    private String team;

    public int getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(int driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getBroadcastName() {
        return broadcastName;
    }

    public void setBroadcastName(String broadcastName) {
        this.broadcastName = broadcastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNameAcronym() {
        return nameAcronym;
    }

    public void setNameAcronym(String nameAcronym) {
        this.nameAcronym = nameAcronym;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getHeadshotUrl() {
        return headshotUrl;
    }

    public void setHeadshotUrl(String headshotUrl) {
        this.headshotUrl = headshotUrl;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverNumber=" + driverNumber +
                ", broadcastName='" + broadcastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", nameAcronym='" + nameAcronym + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", headshotUrl='" + headshotUrl + '\'' +
                ", team=" + team +
                '}';
    }
}
