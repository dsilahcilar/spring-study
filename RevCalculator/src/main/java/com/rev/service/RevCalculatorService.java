package com.rev.service;

import com.rev.model.SumModel;
import com.rev.model.TurbineOutputParameters;
import com.rev.persistence.TurbineData;
import com.rev.repository.TurbineOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevCalculatorService {
    @Autowired
    private TurbineOutputRepository repository;

    public void calculateRevenue(TurbineOutputParameters request) {
        double result = request.getUnitPrice() * Double.valueOf(request.getPowerProd());
        TurbineData turbineData = new TurbineData();
        turbineData.setProd(request.getPowerProd());
        turbineData.setTurbineName(request.getName());
        turbineData.setTimeStamp(request.getTimeStamp());
        turbineData.setRevenue(result);
        save(turbineData);
    }

    public List<TurbineData> getAll() {
        return repository.findAll();
    }

    public List<TurbineData> findByName(String name) {
        return repository.findByTurbineName(name);
    }


    public void save(TurbineData turbineData) {
        TurbineData savedEntity = repository.save(turbineData);
        System.out.println(savedEntity);
    }

    public SumModel sumByName(String name) {
        Object[] result = (Object[]) repository.sumProdSumRevenue(name)[0];
        Double sum = (Double) result[0];
        Long prod = (Long) result[1];
        return new SumModel(sum, prod);
    }

    public TurbineData findById(Long id) {
        return repository.findOne(id);
    }
}
