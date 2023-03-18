package com.adoptable_companions.adoptable_companions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adoptable_companions.adoptable_companions.entity.AdopcionEntity;

@Repository
public interface AdopcionRepository extends JpaRepository<AdopcionEntity, Integer> {
}