package com.f1.sim.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class WeatherDTO {
    @JsonProperty("air_temperature")
    private Double airTemperature;

    @JsonProperty("track_temperature")
    private Double trackTemperature;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("pressure")
    private Double pressure;

    @JsonProperty("rainfall")
    private Double rainfall;

    @JsonProperty("wind_speed")
    private Double windSpeed;

    @JsonProperty("wind_direction")
    private Integer windDirection;

    @JsonProperty("date")
    private OffsetDateTime date;

    @JsonProperty("meeting_key")
    private Integer meetingKey;

    @JsonProperty("session_key")
    private Integer sessionKey;

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

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
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
        return "WeatherDTO{" +
                "airTemperature=" + airTemperature +
                ", trackTemperature=" + trackTemperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", rainfall=" + rainfall +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", date=" + date +
                ", meetingKey=" + meetingKey +
                ", sessionKey=" + sessionKey +
                '}';
    }
}
