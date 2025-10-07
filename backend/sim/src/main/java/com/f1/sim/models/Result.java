package com.f1.sim.models;

import jakarta.persistence.*;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id")
    private Integer resultId;

    // Many results belong to one session. The name of the variable to be the same as that mentioned in the mappedBy.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_key", referencedColumnName = "session_key", nullable = false)
    private Session session;

    // Many results belong to one driver
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_number", referencedColumnName = "driver_number", nullable = false)
    private Driver driver;

    // Many results belong to one team (optional but useful to avoid joins)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = true)
    private Team team;

    @Column(name = "position")
    private Integer position;

    @Column(name = "number_of_laps")
    private Integer numberOfLaps;

    @Column(name = "points")
    private Integer points;

    @Column(name = "dnf")  // Did Not Finish
    private Boolean dnf = false;

    @Column(name = "dns")  // Did Not Start
    private Boolean dns = false;

    @Column(name = "dsq")  // Disqualified
    private Boolean dsq = false;

    @Column(name = "duration") // total race time in seconds
    private Double duration;

    @Column(name = "gap_to_leader") // gap from leader in seconds
    private Double gapToLeader;

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getGapToLeader() {
        return gapToLeader;
    }

    public void setGapToLeader(Double gapToLeader) {
        this.gapToLeader = gapToLeader;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", session=" + session +
                ", driver=" + driver +
                ", team=" + team +
                ", position=" + position +
                ", numberOfLaps=" + numberOfLaps +
                ", points=" + points +
                ", dnf=" + dnf +
                ", dns=" + dns +
                ", dsq=" + dsq +
                ", duration=" + duration +
                ", gapToLeader=" + gapToLeader +
                '}';
    }
}
