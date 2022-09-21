package com.infy.sim.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.sim.dto.CustomerAddressDTO;
import com.infy.sim.service.CustomerAddressService;

@RestController
@RequestMapping("/customeraddress")
public class CustomerAddressController {
	@Autowired
	CustomerAddressService customerAddressService;
	
	@GetMapping
	public ResponseEntity<List<CustomerAddressDTO>> getAllCustomerAddress(){
		return ResponseEntity.ok().body(customerAddressService.getAllCustomerAddress());
	}
	
	@PostMapping
	public ResponseEntity<String> addCustomerAddress(@Valid @RequestBody CustomerAddressDTO customerAddressDTO){
		customerAddressService.addCustomerAddress(customerAddressDTO);
		ResponseEntity<String> entity=new ResponseEntity<>("Customer addrss added successfully.",HttpStatus.CREATED);
		return entity;
		
	}
	
	/*Update Customer Address: Assuming that while purchasing the SIM, communication address has been submitted. 
	 * Now customer should be able to update the address if required for further communication.
	 */
	@PutMapping("/{addressId}/{address}/{city}/{pincode}/{state}")
	public ResponseEntity<CustomerAddressDTO> updateCustomerAddress(@PathVariable
			Integer addressId,@PathVariable
			@Size(max=25,message="Address should be maximumof 25 characters")
			String address,
			@PathVariable
			@Pattern(regexp="[a-zA-Z]*$",message="City should not contain any special characters except space")
			String city,
			@PathVariable
			@Min(value=100000,message="Pin should be 6 digit number")
			@Max(value=999999,message="Pin should be 6 digit number")
			Integer pincode,
			@PathVariable
			@Pattern(regexp="[a-zA-Z]*$",message="State should not contain any special characters except space")
			String state){
		CustomerAddressDTO customerAddressDTO=customerAddressService.updateCustomerAddress(addressId,address,city,pincode,state);
		ResponseEntity<CustomerAddressDTO> entity=new ResponseEntity<>(customerAddressDTO,HttpStatus.ACCEPTED);
		return entity;
		
	}
}
