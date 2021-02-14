package com.spacetree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacetree.entity.UserDepEntity;

@Repository
public interface UserDepRepository extends JpaRepository<UserDepEntity, Long> {
	

	UserDepEntity findByDepId(String depId);

	
}
