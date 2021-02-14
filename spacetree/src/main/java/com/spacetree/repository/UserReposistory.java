package com.spacetree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacetree.entity.UsersEntity;

@Repository
public interface UserReposistory extends JpaRepository<UsersEntity, Long> {
	

	
}
