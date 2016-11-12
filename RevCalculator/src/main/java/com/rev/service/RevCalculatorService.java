package com.rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rev.repository.TurbineOutputRepository;

import com.rev.model.TurbineOutputParameters;
import com.rev.persistence.TurbineData;

public class RevCalculatorService {
	@Autowired
	private TurbineOutputRepository repository;
	
	public void calculateRevenue(TurbineOutputParameters request) {
		double result = request.getUnitPrice() * Double.valueOf(request.getPowerProd());
		TurbineData turbineData = new TurbineData();
		turbineData.setProd(request.getPowerProd());
		turbineData.setTurbineName(request.getName());
		turbineData.setTimeStamp(request.getTimeStamp());
		turbineData.setRevenue(result);
		save(turbineData);
	}
	
	public List<TurbineData> getAll() {
		return repository.findAll();
	}
	
	public List<TurbineData> findByName(String name) {
		return repository.findByTurbineName(name);
	}
	
	public void save(TurbineData turbineData) {
		TurbineData savedEntity = repository.save(turbineData);
		System.out.println(savedEntity);
	}
	
	public Double total() {
		return 100d;
	}
}
