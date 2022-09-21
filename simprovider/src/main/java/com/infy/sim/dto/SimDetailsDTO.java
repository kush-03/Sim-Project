package com.infy.sim.dto;


import com.infy.sim.entity.Customer;
import com.infy.sim.entity.SimDetails;

import com.infy.sim.entity.SimOffers;

import javax.validation.constraints.Size;

public class SimDetailsDTO {
	private Integer simId;
	@Size(min=10,max=10,message="Service number should be10-digit numeric value")
	private String serviceNumber;
	@Size(min=13,max=13,message="SIM number should be 13-digit numeric value")
	private String simNumber;
	private String simStatus;
	private SimOffers offers;
	private Customer customer;
	
	public SimOffers getOffers() {
		return offers;
	}
	public void setOffers(SimOffers offers) {
		this.offers = offers;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getSimId() {
		return simId;
	}
	public void setSimId(Integer simId) {
		this.simId = simId;
	}
	public String getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public String getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}
	public String getSimStatus() {
		return simStatus;
	}
	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}
	
	public SimDetailsDTO(Integer simId, String serviceNumber, String simNumber, String simStatus, SimOffers offers,
			Customer customer) {
		super();
		this.simId = simId;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
		this.offers = offers;
		this.customer = customer;
	}
	
	
	@Override
	public String toString() {
		return "SimDetailsDTO [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + ", offers=" + offers + ", customer=" + customer + "]";
	}
	public SimDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  SimDetails convertDtoToEntity(SimDetailsDTO simDetailsDTO) {
		SimDetails simDetails=new SimDetails();
		simDetails.setServiceNumber(simDetailsDTO.getServiceNumber());
		simDetails.setSimId(simDetailsDTO.getSimId());
		simDetails.setSimNumber(simDetailsDTO.getSimNumber());
		simDetails.setSimStatus(simDetailsDTO.getSimStatus());
		simDetails.setCustomer(simDetailsDTO.getCustomer());
		simDetails.setOffers(simDetailsDTO.getOffers());
		return simDetails;
	}
	
}
