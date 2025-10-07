package com.f1.sim.repository;

import com.f1.sim.models.QualifyingDuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualifyingRepository extends JpaRepository<QualifyingDuration,Integer> {
}
