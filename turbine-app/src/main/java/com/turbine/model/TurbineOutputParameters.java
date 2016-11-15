package com.turbine.model;

public class TurbineOutputParameters {
	private String name;
	private Long timeStamp;
	private Integer powerProd;
	private Double unitPrice;
	
	
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Integer getPowerProd() {
		return powerProd;
	}
	public void setPowerProd(Integer powerProd) {
		this.powerProd = powerProd;
	}
	
	
}
