package com.infy.sim.dto;

import java.time.LocalDate;


import com.infy.sim.entity.CustomerIdentity;
public class CustomerIdentityDTO {

	private String uniqueIdNumber;
	private LocalDate dateOfBirth;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;
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
	public CustomerIdentityDTO(String uniqueIdNumber, LocalDate dateOfBirth, String firstName, String lastName,
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
		return "CustomerIdentityDTO [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", state=" + state + "]";
	}
	
	
	public CustomerIdentityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  CustomerIdentity convertDtoToEntity(CustomerIdentityDTO customerIdentityDTO) {
		CustomerIdentity customerIdentity=new CustomerIdentity();
		
		customerIdentity.setDateOfBirth(customerIdentityDTO.getDateOfBirth());
		customerIdentity.setUniqueIdNumber(customerIdentityDTO.getUniqueIdNumber());
		customerIdentity.setEmailAddress(customerIdentityDTO.getEmailAddress());
		customerIdentity.setFirstName(customerIdentityDTO.getFirstName());
		customerIdentity.setLastName(customerIdentityDTO.getLastName());
		customerIdentity.setState(customerIdentityDTO.getState());
		
		return customerIdentity;
	}
}
