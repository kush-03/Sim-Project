package com.infy.sim.dto;
import com.infy.sim.entity.Customer;
import com.infy.sim.entity.CustomerAddress;
import com.infy.sim.entity.SimDetails;

import java.time.LocalDate;

public class CustomerDTO {
	private String uniqueNumber;
	private LocalDate dateOfBirth;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;
	private String idType;
	private CustomerAddress customerAddress_addressId;
	private SimDetails simId;
	
	public CustomerAddress getCustomerAddress_addressId() {
		return customerAddress_addressId;
	}
	public void setCustomerAddress_addressId(CustomerAddress customerAddress_addressId) {
		this.customerAddress_addressId = customerAddress_addressId;
	}
	public SimDetails getSimId() {
		return simId;
	}
	public void setSimId(SimDetails simId) {
		this.simId = simId;
	}
	public String getUniqueNumber() {
		return uniqueNumber;
	}
	public void setUniqueNumber(String uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
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
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public CustomerDTO(String uniqueNumber, LocalDate dateOfBirth, String firstName, String lastName,
			String emailAddress, String state, String idType) {
		super();
		this.uniqueNumber = uniqueNumber;
		this.dateOfBirth = dateOfBirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.state = state;
		this.idType = idType;
	}
	@Override
	public String toString() {
		return "CustomerDTO [uniqueNumber=" + uniqueNumber + ", dateOfBirth=" + dateOfBirth + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", state=" + state + ", idType="
				+ idType + "]";
	}
	
	
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer convertDtoToEntity(CustomerDTO customerDTO) {
		Customer customer=new Customer();
		customer.setUniqueNumber(customerDTO.getUniqueNumber());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setState(customerDTO.getState());
		customer.setIdType(customerDTO.getIdType());
		customer.setCustomerAddress_addressId(customerDTO.getCustomerAddress_addressId());
	    customer.setSimId(customerDTO.getSimId());
		return customer;
	}
	
}
