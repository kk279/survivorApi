package com.ioco.dto;

import lombok.Data;

@Data
public class SurvivorResponse{

	private String id;
	private String name;
	private String latitude;
	private String longitude;
	private String gender;
	private Integer age;
	private Integer count;
	private Boolean isInfect;
}
