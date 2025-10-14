package com.f1.sim.repository;

import com.f1.sim.models.Stint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StintRepository extends JpaRepository<Stint, Long> {
}
