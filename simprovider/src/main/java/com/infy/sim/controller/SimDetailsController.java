package com.infy.sim.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.sim.dto.SimDetailsDTO;
import com.infy.sim.service.SimDetailsService;

@RestController
@RequestMapping("/simDetails")
public class SimDetailsController {

	@Autowired
	SimDetailsService simDetailsService;
	
	@GetMapping
	public ResponseEntity<List<SimDetailsDTO>> getAllSimDetails(){
		return ResponseEntity.ok().body(simDetailsService.getAllSimDetails());
	}
	
	/*SIM Details:  Customer has to enter the SIM number present in the SIM starter kit and Service number (mobile number), 
	 * so that provider can validate the SIM and Service number. Once details are validated,
	 *  customer should be able to see the available offers for the provided SIM details.
	 */
	
	@GetMapping("/{simNumber}/{serviceNumber}")
	public ResponseEntity<SimDetailsDTO> validateSimDetails(@PathVariable
			@Size(min=13,max=13,message="SIM Number should be 13-digit numeric value")
			String simNumber,@PathVariable
			@Size(min=10,max=10, message="Service number should be 10-digit numeric value")
			String serviceNumber) throws Exception{
		SimDetailsDTO res=simDetailsService.validateSimDetails(simNumber, serviceNumber);
		ResponseEntity<SimDetailsDTO> entity=new ResponseEntity<>(res,HttpStatus.OK);
		return entity;
	}
	
	
	@PostMapping
	public ResponseEntity<String> addSimDetails(@Valid @RequestBody SimDetailsDTO simDetailsDTO){
		simDetailsService.addSimDetails(simDetailsDTO);
		ResponseEntity<String> entity=new ResponseEntity<>("Sim Details added Succesfully.",HttpStatus.CREATED);
		return entity;
	}
}
