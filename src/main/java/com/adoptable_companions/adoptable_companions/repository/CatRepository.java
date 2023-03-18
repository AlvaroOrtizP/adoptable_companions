package com.adoptable_companions.adoptable_companions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adoptable_companions.adoptable_companions.entity.CatEntity;

@Repository
public interface CatRepository extends JpaRepository<CatEntity, Integer>{
	
}
