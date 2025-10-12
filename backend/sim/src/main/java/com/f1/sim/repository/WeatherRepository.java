package com.f1.sim.repository;

import com.f1.sim.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather,Integer> {
}
