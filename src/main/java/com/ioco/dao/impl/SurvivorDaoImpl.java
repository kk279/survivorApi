package com.ioco.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ioco.dao.SurvivorDao;
import com.ioco.entity.SurvivorEntity;
import com.ioco.repository.SurvivorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SurvivorDaoImpl implements SurvivorDao{

	private SurvivorRepository survivorRepository;
	
	@Override
	public SurvivorEntity createSurvivor(SurvivorEntity survivorEntity) {
		return survivorRepository.save(survivorEntity);
	}

	@Override
	public SurvivorEntity getSurvivorById(String id) {
		return survivorRepository.getSurvivorById(id);
	}
	
	@Override
	public List<SurvivorEntity> getSurvivors() {
		return survivorRepository.findAll();
	}
}
