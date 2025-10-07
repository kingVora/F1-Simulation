package com.f1.sim.repository;

import com.f1.sim.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Integer> {
}
