package com.rev.model;

public class SumModel {
	private Double sum = new Double(3.0);
	private Long revenue;

	public SumModel(Double sum, Long revenue) {
		this.sum = sum;
		this.revenue = revenue;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public Long getRevenue() {
		return revenue;
	}

	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}
}
