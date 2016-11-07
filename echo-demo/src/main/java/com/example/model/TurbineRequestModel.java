package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurbineRequestModel {
	private String name;
	private RangeModel pace;
	private RangeModel pressure;
	private RangeModel prodFactor;
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
