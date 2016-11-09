package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rev.model.TurbineOutputParameters;

public interface TurbineOutputRepository extends JpaRepository<TurbineOutputParameters,Long> {
	
}
