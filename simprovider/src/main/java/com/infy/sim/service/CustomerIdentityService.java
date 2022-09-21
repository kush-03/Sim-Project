package com.infy.sim.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.sim.dto.CustomerIdentityDTO;
import com.infy.sim.entity.CustomerIdentity;

import com.infy.sim.repository.CustomerIdentityRepository;

@Service
@Transactional
public class CustomerIdentityService {
	@Autowired
	CustomerIdentityRepository repo;
	
	public List<CustomerIdentityDTO> getAllCustomerIdentity(){
		List<CustomerIdentity> customerIdentity=repo.findAll();
		List<CustomerIdentityDTO> customerIdentityDTO=customerIdentity.stream().map(i->i.convertEntityToDto(i)).toList();
		return customerIdentityDTO;
	}
	
	public void addCustomerIdentity(CustomerIdentityDTO customerIdentityDTO) {
		CustomerIdentity customerIdentity=customerIdentityDTO.convertDtoToEntity(customerIdentityDTO);
		repo.save(customerIdentity);
	}
	
	public String validateCustomerBasicDetails(String email, LocalDate dateOfBirth) throws Exception{
		Optional<CustomerIdentity> customerIdentity=repo.getCustomerByEmail(email);
		if(customerIdentity.isPresent()) {
			if(customerIdentity.get().getDateOfBirth().equals(dateOfBirth)) {
				return "Email and DOB is of Valid Customer";
			}
		}
		throw new Exception("No request placed for you");
	}
	
	/*Customer Personal Details:  As a customer, provide personal details such as first name, last name and confirm email for 
	 * customer personal details validation.Here confirm email acts like OTP to validate the stored customer data. Retrieve customer record based on first name and last name, 
	 * validate entered confirm email with stored email id, if matching return success otherwise return custom error message.
	 */
	public String validateCustomerPersonalDetails(String firstName, String lastName,String confirmEmail) throws Exception{
		Optional<CustomerIdentity> customerIdentity=repo.getCustomerByFirstNameAndLastName(firstName,lastName);
		if(customerIdentity.isPresent()) {
			if(customerIdentity.get().getEmailAddress().equals(confirmEmail)) {
				return "Valid customer Found";
			}else {
				throw new Exception("Invalid email details.");
			}
		}
		throw new Exception("No customer found for the provided details.");
	}
}
