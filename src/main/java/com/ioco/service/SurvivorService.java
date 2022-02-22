package com.ioco.service;

import java.util.List;

import com.ioco.dto.SurvivorResponse;
import com.ioco.dto.SurvivorDto;

public interface SurvivorService {

	public SurvivorDto createSurvivor(SurvivorDto survivorDto);

	public SurvivorDto updateSurvivor(String id, SurvivorDto survivorDto);
	
	public SurvivorDto infectSurvivor(String id);
	
	public List<SurvivorResponse> getSurvivors();
}
