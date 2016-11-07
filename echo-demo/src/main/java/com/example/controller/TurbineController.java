package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.TurbineRequestModel;

@RestController
@RequestMapping("/turbine/config")
public class TurbineController {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public TurbineRequestModel turbine(@RequestBody TurbineRequestModel request ) {
		Object response = restTemplate.postForEntity("http://localhost:8081/turbine/", request, Object.class);
		return request;
	}
}
