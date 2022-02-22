package com.ioco.rest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ioco.constants.SuccessSurvivorApiMessage;
import com.ioco.dto.SurvivorResponse;
import com.ioco.dto.SurvivorDto;
import com.ioco.response.BaseResponse;
import com.ioco.service.SurvivorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Survivor Controller Provider")
@RestController
@RequestMapping("/api/v1")
public class SurvivorController {

	private SurvivorService survivorService;

	@Operation(summary  = "API to create Survivor")
	@PostMapping("/survivor")
	private ResponseEntity<String> createSurvivor(@Valid @RequestBody SurvivorDto survivorDto) {
		survivorService.createSurvivor(survivorDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand().toUri();
		return ResponseEntity.created(location).body(SuccessSurvivorApiMessage.OK_SURVIVOR_CREATED);
	}

	@Operation(summary  = "API to update survivor by Id")
	@PutMapping("/survivor/{id}")
	public ResponseEntity<String> updateSurvivor(@PathVariable(value ="id") String id, @RequestBody SurvivorDto survivorDto) {
		survivorService.updateSurvivor(id, survivorDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand().toUri();
		return ResponseEntity.ok().location(location).body(SuccessSurvivorApiMessage.OK_SURVIVOR_UPDATED);
	}
	
	
	@Operation(summary  = "API to get all survivor")
	@GetMapping("/survivors")
	public ResponseEntity<BaseResponse<SurvivorResponse, String>> getAllSurvivor() {
		List<SurvivorResponse> survivorResponseList = survivorService.getSurvivors();
		BaseResponse<SurvivorResponse, String> response = new BaseResponse<SurvivorResponse, String>();
		response.setDataList(survivorResponseList);
		response.setMessage(SuccessSurvivorApiMessage.OK_SURVIVOR_GET_ALL);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand().toUri();
		return ResponseEntity.ok().location(location).body(response);
	}
	
	@Operation(summary  = "API to infect survivor by Id")
	@PutMapping("/infect/survivor/{id}")
	public ResponseEntity<String> infectSurvivor(@PathVariable(value ="id") String id) {
		survivorService.infectSurvivor(id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand().toUri();
		return ResponseEntity.ok().location(location).body(SuccessSurvivorApiMessage.OK_SURVIVOR_UPDATED);
	}

}
