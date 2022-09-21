package com.infy.sim.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.infy.sim.dto.CustomerIdentityDTO;
import com.infy.sim.service.CustomerIdentityService;

@RestController
@RequestMapping("/customeridentity")
@Validated
public class CustomerIdentityController {

	@Autowired
	CustomerIdentityService customerIdentityService;
	
	@GetMapping
	public ResponseEntity<List<CustomerIdentityDTO>> getAllCustomerIdentity(){
		return ResponseEntity.ok().body(customerIdentityService.getAllCustomerIdentity());
	}
	
	@GetMapping("/{email}/{dateOfBirth}")
	public ResponseEntity<String> validateCustomerDetails(@PathVariable
			@NotBlank(message="Email value is required")
			@Pattern(regexp="[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message="Invalid email")
			String email,@PathVariable
			@DateTimeFormat(pattern="yyyy-MM-dd")
			LocalDate dateOfBirth) throws MethodArgumentTypeMismatchException, Exception{
		String msg=customerIdentityService.validateCustomerBasicDetails(email, dateOfBirth);
		ResponseEntity<String> entity=new ResponseEntity<>(msg,HttpStatus.CREATED);
		return entity;
	}
	
	@PostMapping
	public ResponseEntity<String> addCustomerIdentity(@Valid @RequestBody CustomerIdentityDTO customerIdentityDTO){
		customerIdentityService.addCustomerIdentity(customerIdentityDTO);
		ResponseEntity<String> entity=new ResponseEntity<>("Customer identity added successfully.",HttpStatus.CREATED);
		return entity;
	}
}
