package com.turbine.controller;

import com.turbine.configuration.StartParameters;
import com.turbine.model.Turbine;
import com.turbine.service.TurbineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turbines")
public class TurbineController {
    @Autowired
    private TurbineService turbineService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Turbine> listAll() {
        return turbineService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public StartParameters addNew(@RequestBody StartParameters request) {
        System.out.println("Request geldi " + request.toString());
        turbineService.create(request);
        return request;
    }

    @RequestMapping(path = "/{turbineName}", method = RequestMethod.POST)
    public void start(@PathVariable String turbineName) {
        System.out.println("Turbine name : " + turbineName);
        turbineService.start(turbineName);
    }

    @RequestMapping(path = "/{turbineName}", method = RequestMethod.DELETE)
    public void stop(@PathVariable String turbineName) {
        System.out.println("Turbine name : " + turbineName);
        turbineService.stop(turbineName);
    }

    @RequestMapping(path = "/{turbineName}/{unitPrice}", method = RequestMethod.POST)
    public void updateUnitPrice(@PathVariable String turbineName, @PathVariable Double unitPrice) {
        turbineService.updateUnitPrice(turbineName, unitPrice);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public void stop2(@RequestParam String turbineName) {
        System.out.println("Turbine name : " + turbineName);
        turbineService.stop(turbineName);
    }


}
