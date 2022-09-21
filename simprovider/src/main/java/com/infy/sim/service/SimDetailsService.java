package com.infy.sim.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.sim.dto.SimDetailsDTO;
import com.infy.sim.entity.SimDetails;
import com.infy.sim.repository.SimDetailsRepository;

@Service
@Transactional
public class SimDetailsService {

	@Autowired
	SimDetailsRepository repo;
	public List<SimDetailsDTO> getAllSimDetails(){
		List<SimDetails> simDetails=repo.findAll();
		List<SimDetailsDTO> simDetailsDTO=simDetails.stream().map(i->i.convertEntityToDto(i)).toList();
		return simDetailsDTO;
	}
	public void addSimDetails(SimDetailsDTO simDetailsDTO) {
		SimDetails simDetails=simDetailsDTO.convertDtoToEntity(simDetailsDTO);
		
		repo.save(simDetails);
	}
	public SimDetailsDTO validateSimDetails(String simNumber,String serviceNumber) throws Exception{
		Optional<SimDetails> simDetails=repo.getSimDetailsBySimNumberAndServiceNumber(simNumber, serviceNumber);
		if(simDetails.isPresent()) {
			if("active".equals(simDetails.get().getSimStatus())) {
				throw new Exception("Sim already active");
			}else {
				SimDetailsDTO simDetailsDTO=simDetails.get().convertEntityToDto(simDetails.get());
				return simDetailsDTO;
				}
		}else {
				throw new Exception("Invalid details, please check again SIM number/service number!");
		}
	}
}
