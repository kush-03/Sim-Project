package com.infy.sim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.sim.entity.SimOffers;
@Repository
public interface SimOffersRepository extends JpaRepository<SimOffers,Integer> {

}
