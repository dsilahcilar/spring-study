package com.turbine.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ApplicationProperties properties;
	
	public Collection<Turbine> getAll() {
		return turbineMap.values();
	}
	
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

	public void generatePower(Turbine turbine) {
		int randomPace, randomPressure, randomProdFactor;
		randomPace = getRandom(turbine.getPace().getFirst(), turbine.getPace().getLast());
		randomPressure = getRandom(turbine.getPressure().getFirst(), turbine.getPressure().getLast());
		randomProdFactor = getRandom(turbine.getProdFactor().getFirst(), turbine.getProdFactor().getLast());
		int result = ((randomPace * randomPressure) / (randomPace + randomPressure)) * randomProdFactor;
		System.out.println("turbineName " + turbine.getName() + " result " + result);
		callRevCalculator(turbine, result);
	}


	public int getRandom(int first, int last) {
		Random r = new Random();
		return r.nextInt(last) + first;
	}


	public void start(String turbineName) {
		Turbine turbine = turbineMap.get(turbineName);
		turbine.setState(State.active);
	}
	
	public void stop(String turbineName) {
		Turbine turbine = turbineMap.get(turbineName);
		turbine.setState(State.passive);
	}

	public void callRevCalculator(Turbine turbine, int result) {
		if(turbine.getState() == State.active) {
			send(turbine, result);
		}
	}

	public void send(Turbine turbine,int result) {
		TurbineOutputParameters parameters = new TurbineOutputParameters();
		parameters.setName(turbine.getName());
		parameters.setPowerProd(result);
		parameters.setTimeStamp(Calendar.getInstance().getTimeInMillis());
		parameters.setUnitPrice(turbine.getUnitPrice());
		System.out.println("timeStamp" + parameters.getTimeStamp());
		restTemplate.postForEntity(properties.getUrl() + "/rev/" , parameters , Void.class);
	}
	
	
}
