package com.example.model;

public class TurbineRequestModel {
	private String name;

	private String state;

	private RangeModel pace;
	private RangeModel pressure;
	private RangeModel prodFactor;
	private Double unitPrice = new Double(3.0);

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RangeModel getPace() {
		return pace;
	}
	public void setPace(RangeModel pace) {
		this.pace = pace;
	}
	public RangeModel getPressure() {
		return pressure;
	}
	public void setPressure(RangeModel pressure) {
		this.pressure = pressure;
	}
	public RangeModel getProdFactor() {
		return prodFactor;
	}
	public void setProdFactor(RangeModel prodFactor) {
		this.prodFactor = prodFactor;
	}
	
	
	
}
