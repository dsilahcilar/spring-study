package com.turbine.model;

import java.util.Calendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.turbine.configuration.ApplicationProperties;
import com.turbine.configuration.RangeModel;

public class Turbine {
	private State state;
	private String name;
	private RangeModel pace;
	private RangeModel pressure;
	private RangeModel prodFactor;
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ApplicationProperties properties;
	
	public void generatePower() {
		int randomPace, randomPressure, randomProdFactor;
		randomPace = getRandom(pace.getFirst(), pace.getLast());
		randomPressure = getRandom(pressure.getFirst(), pressure.getLast());
		randomProdFactor = getRandom(prodFactor.getFirst(), prodFactor.getLast());
		int result = ((randomPace * randomPressure) / (randomPace + randomPressure)) * randomProdFactor;
		System.out.println("turbineName " + name + " result " + result);
		callRevCalculator(result);
	}
	
	public void callRevCalculator(int result) {
		if(this.getState() == State.active) {
			send(this, result);
		}
	}
	
	public void send(Turbine turbine,int result) {
		TurbineOutputParameters parameters = new TurbineOutputParameters();
		parameters.setName(turbine.getName());
		parameters.setPowerProd(result);
		parameters.setTimeStamp(Calendar.getInstance().getTimeInMillis());
		System.out.println("timeStamp" + parameters.getTimeStamp());
		restTemplate.postForEntity(properties.getUrl() + "/rev/" , parameters , Void.class);
	}
	
	public int getRandom(int first, int last) {
		Random r = new Random();
		//TODO fixIt
		return r.nextInt(pace.getLast()); 
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
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
