package service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rev.repository.TurbineOutputRepository;

import model.TurbineOutputParameters;

public class RevCalculatorService {
	@Autowired
	private TurbineOutputRepository repository;
	
	public void calculateRevenue(TurbineOutputParameters request) {
		double result = request.getUnitPrice() * Double.valueOf(request.getPowerProd());
		save();
	}
	
	public void save() {
		repository.save(new TurbineOutputParameters());
		System.out.println("Saved");
	}
}
