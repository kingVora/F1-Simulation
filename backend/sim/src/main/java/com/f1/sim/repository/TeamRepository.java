package com.f1.sim.repository;

import com.f1.sim.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Integer> {

    Team findByTeamName(String teamName);
}
