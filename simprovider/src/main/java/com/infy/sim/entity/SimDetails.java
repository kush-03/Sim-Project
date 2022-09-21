package com.infy.sim.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infy.sim.dto.SimDetailsDTO;

@Entity
@JsonIgnoreProperties(value = {"offers","customer"})
public class SimDetails {
	@Id
	private Integer simId;
	private String serviceNumber;
	private String simNumber;
	private String simStatus;
	
	@OneToOne(mappedBy="simDetails")
	private SimOffers offers;
	@OneToOne(mappedBy="simId")
	private Customer customer;
	
	
	public SimDetails() {
		super();
		// TODO Auto-generated constructor stub
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
	public SimDetails(Integer simId, String serviceNumber, String simNumber, String simStatus, SimOffers offers,
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
		return "SimDetails [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + ", offers=" + offers + ", customer=" + customer + "]";
	}
	public  SimDetailsDTO convertEntityToDto(SimDetails simDetails) {
		SimDetailsDTO simDetailsDTO=new SimDetailsDTO();
		simDetailsDTO.setServiceNumber(simDetails.getServiceNumber());
		simDetailsDTO.setSimId(simDetails.getSimId());
		simDetailsDTO.setSimNumber(simDetails.getSimNumber());
		simDetailsDTO.setSimStatus(simDetails.getSimStatus());
		simDetailsDTO.setCustomer(simDetails.getCustomer());
		simDetailsDTO.setOffers(simDetails.getOffers());
		return simDetailsDTO;
	}
	
}
