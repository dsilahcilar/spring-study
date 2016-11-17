package com.rev.controller;

import com.rev.configuration.ApplicationProperties;
import com.rev.model.Message;
import com.rev.model.ResponseType;
import com.rev.model.SumModel;
import com.rev.model.TurbineOutputParameters;
import com.rev.persistence.TurbineData;
import com.rev.service.RevCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@RequestMapping("/rev")
@RestController
public class RevController {
    @Autowired
    private RevCalculatorService revCalculatorService;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApplicationProperties applicationProperties;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseType calculateRevenue(@RequestBody TurbineOutputParameters request) {
        System.out.println("TurbineOutputParameters  " + request.toString());
        revCalculatorService.calculateRevenue(request);
        Message message = new Message(request.getName(), request.getPowerProd(), Calendar.getInstance().getTime().getTime());
        restTemplate.postForEntity(applicationProperties.getUrl() + "/turbines/websocket", message, Object.class);
        return new ResponseType("Ok", LocalDateTime.now());
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public List<TurbineData> getAll() {
        return revCalculatorService.getAll();
    }


    @RequestMapping(path = "/id/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public TurbineData findById(@PathVariable Long id) {
        return revCalculatorService.findById(id);
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public List<TurbineData> findByName(@PathVariable String name) {
        return revCalculatorService.findByName(name);
    }

    @RequestMapping(path = "/{name}/sum", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public SumModel sumByName(@PathVariable String name) {
        return revCalculatorService.sumByName(name);
    }

}
