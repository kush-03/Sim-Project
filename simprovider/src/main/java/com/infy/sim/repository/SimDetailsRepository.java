package com.infy.sim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.sim.entity.SimDetails;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetails,Integer>{
	@Query("select sim from SimDetails sim where sim.simNumber=?1 and sim.serviceNumber=?2")
	public Optional<SimDetails> getSimDetailsBySimNumberAndServiceNumber(String simNumber, String serviceNumber);
}
