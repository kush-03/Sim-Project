package com.infy.sim.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.sim.dto.CustomerDTO;
import com.infy.sim.entity.Customer;
import com.infy.sim.entity.CustomerAddress;
import com.infy.sim.entity.SimDetails;
import com.infy.sim.repository.CustomerAddressRepository;
import com.infy.sim.repository.CustomerRepository;
import com.infy.sim.repository.SimDetailsRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository repo;
	@Autowired
	CustomerAddressRepository caRepo;
	@Autowired
	SimDetailsRepository sdRepo;
	
	public List<CustomerDTO> getAllCustomer(){
		List<Customer> customer=repo.findAll();
		List<CustomerDTO> customerDTO=customer.stream().map(i->i.convertEntityToDto(i)).toList();
		return customerDTO;
	}
	
	public void addCustomer(CustomerDTO customerDTO) throws Exception{
		Customer customer=customerDTO.convertDtoToEntity(customerDTO);
		Optional<CustomerAddress> customerAddress=caRepo.findById(customerDTO.getCustomerAddress_addressId().getAddressId());
		Optional<SimDetails> simDetails=sdRepo.findById(customerDTO.getSimId().getSimId());
		
		if(customerAddress.isPresent()&&simDetails.isPresent()) {
			customer.setSimId(simDetails.get());
			customer.setCustomerAddress_addressId(customerAddress.get());
			repo.save(customer);
		}else {
			throw new Exception("Customer Address/Sim Details are Invalid");
		}
	}
	
	
	/*Customer ID Proof Validation: Customer should provide valid government identify proof(Example: Aadhar id, passport etc). 
	Here you can consider Aadharcard for Id proof check.*/
	
	public String verifyCustomerAndActivateSim(String aadharNumber,String firstName,String lastName,LocalDate dob) throws Exception{
		Optional<Customer> customer=repo.findById(aadharNumber);
		if(customer.isPresent()) {
			if(customer.get().getFirstName().equals(firstName)&& customer.get().getLastName().equals(lastName)) {
				if(customer.get().getDateOfBirth().equals(dob)) {
					SimDetails simDetails=customer.get().getSimId();
					if("active".equals(simDetails.getSimStatus())) {
						throw new Exception("SIM already active");
					}else {
						simDetails.setSimStatus("active");
						return "Customer sim activated successfully";
					}
				}else {
					throw new Exception("Incorrect date of birth details.");
				}
			}else {
				throw new Exception("Invalid Firstname/lastname details.");
			}
		}
			throw new Exception("Invalid aadhar number");
	}
}
