package com.f1.sim.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "weather_id")
    private Long weatherId;

    @Column(name = "meeting_key", nullable = false)
    private Integer meetingKey;

    @Column(name = "session_key", nullable = false)
    private Integer sessionKey;

    @Column(name = "date", nullable = false)
    private OffsetDateTime date;

    @Column(name = "air_temperature")
    private Double airTemperature;

    @Column(name = "track_temperature")
    private Double trackTemperature;

    @Column(name = "humidity")
    private Integer humidity;

    @Column(name = "pressure")
    private Double pressure;

    @Column(name = "rainfall")
    private Double rainfall;

    @Column(name = "wind_speed")
    private Double windSpeed;

    @Column(name = "wind_direction")
    private Integer windDirection;

    public Long getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Long weatherId) {
        this.weatherId = weatherId;
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

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public Double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(Double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public Double getTrackTemperature() {
        return trackTemperature;
    }

    public void setTrackTemperature(Double trackTemperature) {
        this.trackTemperature = trackTemperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getRainfall() {
        return rainfall;
    }

    public void setRainfall(Double rainfall) {
        this.rainfall = rainfall;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weatherId=" + weatherId +
                ", meetingKey=" + meetingKey +
                ", sessionKey=" + sessionKey +
                ", date=" + date +
                ", airTemperature=" + airTemperature +
                ", trackTemperature=" + trackTemperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", rainfall=" + rainfall +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                '}';
    }
}
