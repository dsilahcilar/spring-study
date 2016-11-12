package com.rev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rev.persistence.TurbineData;

public interface TurbineOutputRepository extends JpaRepository<TurbineData,Long> {
	  // @Query("SELECT sum(t.revenue), sum(t.prod) u from TurbineData t where t.turbineName = ?1")
	  // Object sumProdSumRevenue();
	  List<TurbineData> findByTurbineName(String name);
}
