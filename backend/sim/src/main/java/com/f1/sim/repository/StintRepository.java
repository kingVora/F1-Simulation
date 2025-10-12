package com.f1.sim.repository;

import com.f1.sim.models.Stint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StintRepository extends JpaRepository<Stint, Long> {
}
