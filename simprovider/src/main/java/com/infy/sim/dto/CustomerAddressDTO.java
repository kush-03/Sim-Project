package com.infy.sim.dto;
import com.infy.sim.entity.Customer;
import com.infy.sim.entity.CustomerAddress;

public class CustomerAddressDTO {
	private Integer addressId;
	private String address;
	private String city;
	private Integer pincode;
	private String state;
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	
	public CustomerAddressDTO(Integer addressId, String address, String city, Integer pincode, String state,
			Customer customer) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerAddressDTO [addressId=" + addressId + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + ", customer=" + customer + "]";
	}
	
	public CustomerAddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  CustomerAddress convertDtoToEntity(CustomerAddressDTO customerAddressDTO) {
		CustomerAddress customerAddress=new CustomerAddress();
		
		customerAddress.setAddressId(customerAddressDTO.getAddressId());
		customerAddress.setAddress(customerAddressDTO.getAddress());
		customerAddress.setCity(customerAddressDTO.getCity());
		customerAddress.setPincode(customerAddressDTO.getPincode());
		customerAddress.setState(customerAddressDTO.getState());
		customerAddress.setCustomer(customerAddressDTO.getCustomer());
		return customerAddress;
		
	}
	
	
}
