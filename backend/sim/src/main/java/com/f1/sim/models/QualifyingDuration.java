package com.f1.sim.models;

import jakarta.persistence.*;

@Entity
@Table(name = "qualifyingduration")
public class QualifyingDuration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "segment_number")
    private Integer segmentNumber;

    @Column(name = "duration")
    private Double duration;

    @Column(name = "gap_to_leader")
    private Double gapToLeader;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id", nullable = false)
    private Result result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSegmentNumber() {
        return segmentNumber;
    }

    public void setSegmentNumber(Integer segmentNumber) {
        this.segmentNumber = segmentNumber;
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "QualifyingDuration{" +
                "id=" + id +
                ", segmentNumber=" + segmentNumber +
                ", duration=" + duration +
                ", gapToLeader=" + gapToLeader +
                ", result=" + result +
                '}';
    }
}
