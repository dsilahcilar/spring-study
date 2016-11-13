package com.rev.model;

public class SumModel {
	private Double revenue;
	private Long prod;
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	public Long getProd() {
		return prod;
	}
	public void setProd(Long prod) {
		this.prod = prod;
	}
	public SumModel(Double revenue, Long prod) {
		super();
		this.revenue = revenue;
		this.prod = prod;
	}

	
	
}

	
