package com.example.controller;

import com.example.ApplicationProperties;
import com.example.model.TurbineRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class TurbineController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApplicationProperties applicationProperties;

    @RequestMapping(path = "/turbine/config", method = RequestMethod.POST)
    public TurbineRequestModel turbine(@RequestBody TurbineRequestModel request) {
        Object response = restTemplate.postForEntity(applicationProperties.getUrl() + "/turbines", request, Object.class);
        return request;
    }


    @RequestMapping(path = "/turbines", method = RequestMethod.GET)
    public List<TurbineRequestModel> list() {
        ResponseEntity<TurbineRequestModel[]> response = restTemplate.getForEntity(applicationProperties.getUrl() + "/turbines", TurbineRequestModel[].class);
        return Arrays.asList(response.getBody());
    }

    @RequestMapping(path = "/turbines/{turbineName}", method = RequestMethod.POST)
    public void start(@PathVariable String turbineName) {
        restTemplate.postForEntity(applicationProperties.getUrl() + "/turbines/" + turbineName, null, TurbineRequestModel[].class);
    }

    @RequestMapping(path = "/turbines/{turbineName}", method = RequestMethod.DELETE)
    public void stop(@PathVariable String turbineName) {
        restTemplate.delete(applicationProperties.getUrl() + "/turbines/" + turbineName, TurbineRequestModel[].class);
    }

    @RequestMapping(path = "/turbines/{turbineName}/{unitPrice}", method = RequestMethod.POST)
    public void updateUnitPrice(@PathVariable String turbineName, @PathVariable Double unitPrice) {
        restTemplate.postForLocation(applicationProperties.getUrl() + "/turbines/" + turbineName + "/" + unitPrice , TurbineRequestModel[].class);
    }


}
