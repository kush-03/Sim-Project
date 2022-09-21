package com.infy.sim.dto;

import com.infy.sim.entity.SimDetails;
import com.infy.sim.entity.SimOffers;

public class SimOffersDTO {
	private Integer offerId;
	private Integer callQty;
	private Integer cost;
	private Integer dataQty;
	private Integer duration;
	private String offerName;
	private SimDetails simDetails;
	
	
	public SimDetails getSimDetails() {
		return simDetails;
	}
	public void setSimDetails(SimDetails simDetails) {
		this.simDetails = simDetails;
	}
	public Integer getOfferId() {
		return offerId;
	}
	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}
	public Integer getCallQty() {
		return callQty;
	}
	public void setCallQty(Integer callQty) {
		this.callQty = callQty;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getDataQty() {
		return dataQty;
	}
	public void setDataQty(Integer dataQty) {
		this.dataQty = dataQty;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	
	public SimOffersDTO(Integer offerId, Integer callQty, Integer cost, Integer dataQty, Integer duration,
			String offerName, SimDetails simDetails) {
		super();
		this.offerId = offerId;
		this.callQty = callQty;
		this.cost = cost;
		this.dataQty = dataQty;
		this.duration = duration;
		this.offerName = offerName;
		this.simDetails = simDetails;
	}
	
	@Override
	public String toString() {
		return "SimOffersDTO [offerId=" + offerId + ", callQty=" + callQty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerName=" + offerName + ", simDetails=" + simDetails + "]";
	}
	public SimOffersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  SimOffers convertDtoToEntity(SimOffersDTO simOffersDTO) {
		SimOffers simOffers=new SimOffers();
		simOffers.setCallQty(simOffersDTO.getCallQty());
		simOffers.setCost(simOffersDTO.getCost());
		simOffers.setDataQty(simOffersDTO.getDataQty());
		simOffers.setDuration(simOffersDTO.getDuration());
		simOffers.setOfferId(simOffersDTO.getOfferId());
		simOffers.setOfferName(simOffersDTO.getOfferName());
		simOffers.setSimDetails(simOffersDTO.getSimDetails());
		return simOffers;
	}
}
