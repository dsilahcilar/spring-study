package com.example.controller;

import java.util.Calendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.FirstResponseModel;

@RestController
@RequestMapping(path="/first")
public class FirstController {
	
	
	@RequestMapping("/echo")
	public String echo() {
		return "selam";
	}
	
	@RequestMapping(path = "/echo", method= RequestMethod.POST)
	public String echo2() {
		return "selam";
	}
	
	@RequestMapping("/echoWithTs")
	public String echoWithTs() {
		return "selam  " + Calendar.getInstance().getTime(); 
	}
	
	@RequestMapping("/echoJson")
	public FirstResponseModel echoWithJson() {
		FirstResponseModel fm = new FirstResponseModel();
		fm.setName("deniz");
		fm.setLastName("silahcilar");
		return fm;
	}
}
