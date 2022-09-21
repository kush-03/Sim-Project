package com.infy.sim.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.infy.sim.dto.CustomerDTO;

import javax.persistence.JoinColumn;

@Entity
public class Customer {
	@Id
	private String uniqueNumber;
	private LocalDate dateOfBirth;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;
	private String idType;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="customerAddress_addressId",referencedColumnName="addressId")
	private CustomerAddress customerAddress_addressId;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="simId",referencedColumnName="simId")
	private SimDetails simId;
	
	
	
	public SimDetails getSimId() {
		return simId;
	}
	public void setSimId(SimDetails simId) {
		this.simId = simId;
	}
	public String getUniqueNumber() {
		return uniqueNumber;
	}
	public Customer(String uniqueNumber, LocalDate dateOfBirth, String firstName, String lastName, String emailAddress,
			String state, String idType, CustomerAddress customerAddress_addressId) {
		super();
		this.uniqueNumber = uniqueNumber;
		this.dateOfBirth = dateOfBirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.state = state;
		this.idType = idType;
		this.customerAddress_addressId = customerAddress_addressId;
	}
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
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
	public CustomerAddress getCustomerAddress_addressId() {
		return customerAddress_addressId;
	}
	public void setCustomerAddress_addressId(CustomerAddress customerAddress_addressId) {
		this.customerAddress_addressId = customerAddress_addressId;
	}
	@Override
	public String toString() {
		return "Customer [uniqueNumber=" + uniqueNumber + ", dateOfBirth=" + dateOfBirth + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", state=" + state + ", idType="
				+ idType + ", customerAddress_addressId=" + customerAddress_addressId + "]";
	}

	public CustomerDTO convertEntityToDto(Customer customer) {
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setUniqueNumber(customer.getUniqueNumber());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		customerDTO.setState(customer.getState());
		customerDTO.setIdType(customer.getIdType());
		customerDTO.setCustomerAddress_addressId(customer.getCustomerAddress_addressId());
		customerDTO.setSimId(customer.getSimId());
		return customerDTO;
	}
}
