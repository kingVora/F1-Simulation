package com.f1.sim.repository;

import com.f1.sim.models.Lap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapRepository extends JpaRepository<Lap,Integer> {
}
