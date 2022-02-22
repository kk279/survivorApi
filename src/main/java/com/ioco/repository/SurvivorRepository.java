package com.ioco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ioco.entity.SurvivorEntity;

@Repository
public interface SurvivorRepository extends JpaRepository<SurvivorEntity, Long> {

	public SurvivorEntity getSurvivorById(String id);

}
