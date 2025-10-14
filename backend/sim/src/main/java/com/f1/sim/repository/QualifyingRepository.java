package com.f1.sim.repository;

import com.f1.sim.models.QualifyingDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualifyingRepository extends JpaRepository<QualifyingDuration,Integer> {
}
