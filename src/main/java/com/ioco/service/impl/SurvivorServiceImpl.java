package com.ioco.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ioco.constants.ErrorSurvivorApiMessage;
import com.ioco.dao.SurvivorDao;
import com.ioco.dto.SurvivorResponse;
import com.ioco.dto.SurvivorDto;
import com.ioco.entity.SurvivorEntity;
import com.ioco.exception.SurvivorApiException;
import com.ioco.service.SurvivorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SurvivorServiceImpl implements SurvivorService {

	private SurvivorDao survivorDao;

	private ModelMapper modelMapper;

	@Override
	public SurvivorDto createSurvivor(SurvivorDto survivorDto) {
		SurvivorEntity survivorEntity = modelMapper.map(survivorDto, SurvivorEntity.class);
		survivorDao.createSurvivor(survivorEntity);
		return modelMapper.map(survivorEntity, SurvivorDto.class);
	}

	@Override
	public SurvivorDto updateSurvivor(String id, SurvivorDto survivorDto) {
		Optional<SurvivorEntity> survivorEntityOptional = Optional.of(survivorDao.getSurvivorById(id));
		if(!survivorEntityOptional.isPresent() && survivorEntityOptional.isEmpty()) {
			throw new SurvivorApiException(ErrorSurvivorApiMessage.SURVIVOR_NOT_FOUND);
		}
		SurvivorEntity survivorEntity = survivorEntityOptional.get();
		modelMapper.map(survivorDto, survivorEntity);
		survivorDao.createSurvivor(survivorEntity);
		if (!Objects.isNull(survivorEntity)) {
			System.out.println("Survivor has been updated successfully!");
		}
		return modelMapper.map(survivorEntity, SurvivorDto.class);
	}
	
	@Override
	public SurvivorDto infectSurvivor(String id) {
		Optional<SurvivorEntity> survivorEntityOptional = Optional.of(survivorDao.getSurvivorById(id));
		if(!survivorEntityOptional.isPresent() && survivorEntityOptional.isEmpty()) {
			throw new SurvivorApiException(ErrorSurvivorApiMessage.SURVIVOR_NOT_FOUND);
		}
		SurvivorEntity survivorEntity = survivorEntityOptional.get();
		int count = survivorEntity.getCount();
		count++;
		if(count >= 3) {
			survivorEntity.setIsInfect(true);
		}
		survivorEntity.setCount(count);
		survivorDao.createSurvivor(survivorEntity);
		return modelMapper.map(survivorEntity, SurvivorDto.class);
	}
	
	@Override
	public List<SurvivorResponse> getSurvivors() {
		List<SurvivorEntity> survivors = survivorDao.getSurvivors();
		if (Objects.nonNull(survivors) && !survivors.isEmpty()) {
			return survivors.stream().map(projectEntity -> modelMapper.map(projectEntity, SurvivorResponse.class)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
