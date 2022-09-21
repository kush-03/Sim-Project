package com.infy.sim.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;

import com.infy.sim.dto.CustomerIdentityDTO;


@Entity
public class CustomerIdentity {
	@Id
	private String uniqueIdNumber;
	private LocalDate dateOfBirth;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;
	
	
	public CustomerIdentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUniqueIdNumber() {
		return uniqueIdNumber;
	}
	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public CustomerIdentity(String uniqueIdNumber, LocalDate dateOfBirth, String firstName, String lastName,
			String emailAddress, String state) {
		super();
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfBirth = dateOfBirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.state = state;
	}
	@Override
	public String toString() {
		return "CustomerIdentity [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", state=" + state + "]";
	}
	
	public  CustomerIdentityDTO convertEntityToDto(CustomerIdentity customerIdentity) {
		CustomerIdentityDTO customerIdentityDTO=new CustomerIdentityDTO();
		
		customerIdentityDTO.setDateOfBirth(customerIdentity.getDateOfBirth());
		customerIdentityDTO.setUniqueIdNumber(customerIdentity.getUniqueIdNumber());
		customerIdentityDTO.setEmailAddress(customerIdentity.getEmailAddress());
		customerIdentityDTO.setFirstName(customerIdentity.getFirstName());
		customerIdentityDTO.setLastName(customerIdentity.getLastName());
		customerIdentityDTO.setState(customerIdentity.getState());
		
		return customerIdentityDTO;
	}

}
