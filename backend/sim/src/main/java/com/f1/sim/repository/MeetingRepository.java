package com.f1.sim.repository;

import com.f1.sim.models.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting,Integer> {
}
