package com.ioco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name= "survivor")
public class SurvivorEntity {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false)
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "count")
	private Integer count;
	
	@Column(name = "infect")
	private Boolean isInfect;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Boolean getIsInfect() {
		return isInfect;
	}

	public void setIsInfect(Boolean isInfect) {
		this.isInfect = isInfect;
	}
	
	
	
}
