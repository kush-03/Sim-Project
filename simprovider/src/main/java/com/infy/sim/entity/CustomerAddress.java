package com.infy.sim.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infy.sim.dto.CustomerAddressDTO;


@Entity
@JsonIgnoreProperties(value = {"customer"})
public class CustomerAddress {

	@Id
	private Integer addressId;
	private String address;
	private String city;
	private Integer pincode;
	private String state;
	@OneToOne(mappedBy="customerAddress_addressId")
	private Customer customer;
	
	
	public CustomerAddress(Integer addressId, String address, String city, Integer pincode, String state,
			Customer customer) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.customer = customer;
	}
	
	public CustomerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + ", customer=" + customer + "]";
	}
	public  CustomerAddressDTO convertEntityToDto(CustomerAddress customerAddress) {
		CustomerAddressDTO customerAddressDTO=new CustomerAddressDTO();
		
		customerAddressDTO.setAddressId(customerAddress.getAddressId());
		customerAddressDTO.setAddress(customerAddress.getAddress());
		customerAddressDTO.setCity(customerAddress.getCity());
		customerAddressDTO.setPincode(customerAddress.getPincode());
		customerAddressDTO.setState(customerAddress.getState());
		customerAddressDTO.setCustomer(customerAddress.getCustomer());
		return customerAddressDTO;
		
	}
	

}
