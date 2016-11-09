package com.rev.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rev.model.ResponseType;
import com.rev.model.TurbineOutputParameters;
import com.rev.service.RevCalculatorService;

@RequestMapping("/rev")
public class RevController {
	@Autowired
	private RevCalculatorService revCalculatorService;
	
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseType calculateRevenue(@RequestBody TurbineOutputParameters request) {
		System.out.println("TurbineOutputParameters  " + request.toString() );
		revCalculatorService.calculateRevenue(request);
		return new ResponseType("Ok", LocalDateTime.now());
	}
}
