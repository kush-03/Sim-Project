package com.infy.sim.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.sim.dto.SimOffersDTO;
import com.infy.sim.entity.SimDetails;
import com.infy.sim.entity.SimOffers;
import com.infy.sim.repository.SimDetailsRepository;
import com.infy.sim.repository.SimOffersRepository;







@Service
@Transactional
public class SimOffersService {
	@Autowired
	SimOffersRepository repo;
	@Autowired
	SimDetailsRepository sDRepo;
	
	public List<SimOffersDTO> getAllSimOffers(){
		List<SimOffers> simOffers=repo.findAll();
		List<SimOffersDTO> simOffersDTO=simOffers.stream().map(i->i.convertEntityToDto(i)).toList();
		return simOffersDTO;
	}
	
	public void addSimOffers(SimOffersDTO simOffersDTO) {
		SimOffers simOffers=simOffersDTO.convertDtoToEntity(simOffersDTO);
		Optional<SimDetails> simDetails=sDRepo.findById(simOffersDTO.getSimDetails().getSimId());
		if(simDetails.isPresent()) {
			simOffers.setSimDetails(simDetails.get());
			repo.save(simOffers);
		}
		else {
			System.out.println("SimId Not Found");
		}
	}
}
