package com.f1.sim.repository;

import com.f1.sim.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PositionRepository extends JpaRepository<Position,Long> {
}
