package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rev.persistence.TurbineData;

public interface TurbineOutputRepository extends JpaRepository<TurbineData,Long> {
	
}
