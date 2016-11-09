package com.rev.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TurbineData {
	@Id
	private Long id;
	private Double revenue;
	private Integer prod;
	private String turbineName;
	private Long timeStamp;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	public Integer getProd() {
		return prod;
	}
	public void setProd(Integer prod) {
		this.prod = prod;
	}
	public String getTurbineName() {
		return turbineName;
	}
	public void setTurbineName(String turbineName) {
		this.turbineName = turbineName;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
