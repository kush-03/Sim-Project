package com.infy.sim.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import com.infy.sim.dto.CustomerDTO;
import com.infy.sim.service.CustomerService;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
		return ResponseEntity.ok().body(customerService.getAllCustomer());
	}
	
	/*Customer ID Proof Validation: Customer should provide valid government identify proof(Example: Aadhar id, passport etc). 
	 */
	@PutMapping("/{aadharNumber}/{firstName}/{lastName}/{dob}")
	public ResponseEntity<String> verifyCustomerAndServiceSim(@PathVariable
			@Size(min=16,max=16)
			@Pattern(regexp="[0-9]{16}")
			String aadharNumber,
			@PathVariable String firstName,
			@PathVariable String lastName,
			@DateTimeFormat(pattern="yyyy-MM-dd")
			@PathVariable LocalDate dob) throws MethodArgumentTypeMismatchException, Exception{
		String msg=customerService.verifyCustomerAndActivateSim(aadharNumber,firstName,lastName,dob);
		ResponseEntity<String> entity=new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
		return entity;
	}
	
	@PostMapping
	public ResponseEntity<String> addCustomerAddress(@Valid @RequestBody CustomerDTO customerDTO) throws Exception{
		customerService.addCustomer(customerDTO);
		ResponseEntity<String> entity=new ResponseEntity<>("Customer added successfully.",HttpStatus.CREATED);
		return entity;
	}
}
