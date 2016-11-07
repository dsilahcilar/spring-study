package com.turbine.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.turbine.configuration.StartParameters;

@RestController
@RequestMapping("/turbine")
public class TurbineController {
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public StartParameters addNew(@RequestBody StartParameters request) {
		System.out.println("Request geldi " + request.toString() );
		return request;
	}
}
