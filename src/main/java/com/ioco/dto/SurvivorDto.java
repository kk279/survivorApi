package com.ioco.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SurvivorDto {
	
	@NotBlank
	@Schema(description = "Name of Survivor ", example = "Mobile")
	private String name;
	
	@Schema(description = "latitude ", example = "27.605621")
	private String latitude;
	
	@Schema(description = "longitude ", example = "78.053780")
	private String longitude;
	
	@Schema(description = "gender ", example = "Male")
	private String gender;
	
	@Schema(description = "age ", example = "20")
	private Integer age;

}
