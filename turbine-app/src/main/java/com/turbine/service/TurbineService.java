package com.turbine.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.turbine.configuration.ApplicationProperties;
import com.turbine.configuration.StartParameters;
import com.turbine.model.State;
import com.turbine.model.Turbine;
import com.turbine.model.TurbineOutputParameters;

@Service
public class TurbineService {
	private Map<String,Turbine> turbineMap = new HashMap<>();
	
	
	public Map<String, Turbine> getTurbineMap() {
		return turbineMap;
	}

	public void create(StartParameters request) {
		Turbine turbine = new Turbine();
		turbine.setName(request.getName());
		turbine.setPace(request.getPace());
		turbine.setPressure(request.getPressure());
		turbine.setProdFactor(request.getProdFactor());
		turbine.setState(State.passive);
		turbineMap.put(turbine.getName(), turbine);
	}
	
	public void start(String turbineName) {
		Turbine turbine = turbineMap.get(turbineName);
		turbine.setState(State.active);
	}
	
	public void stop(String turbineName) {
		Turbine turbine = turbineMap.get(turbineName);
		turbine.setState(State.passive);
	}
	
	
}
