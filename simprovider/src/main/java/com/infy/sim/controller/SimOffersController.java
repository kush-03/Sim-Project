package com.infy.sim.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.sim.dto.SimOffersDTO;
import com.infy.sim.service.SimOffersService;

@RestController
@RequestMapping("/simoffers")
@Validated
public class SimOffersController {
	@Autowired
	SimOffersService simOffersService;
	
	@GetMapping
	public ResponseEntity<List<SimOffersDTO>> getAllSimOffers(){
		return ResponseEntity.ok().body(simOffersService.getAllSimOffers());
	}
	@PostMapping
	public ResponseEntity<String> addSimOffers(@Valid @RequestBody SimOffersDTO simOfferDTO){
		simOffersService.addSimOffers(simOfferDTO);
		ResponseEntity<String> entity=new ResponseEntity<>("Sim offer added successfully.",HttpStatus.CREATED);
		return entity;
	}
}
