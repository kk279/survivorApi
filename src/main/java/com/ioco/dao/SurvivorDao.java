package com.ioco.dao;

import java.util.List;

import com.ioco.entity.SurvivorEntity;

public interface SurvivorDao {
	
	public SurvivorEntity createSurvivor(SurvivorEntity survivorEntity);

	public SurvivorEntity getSurvivorById(String id);
	
	public List<SurvivorEntity> getSurvivors();
}
