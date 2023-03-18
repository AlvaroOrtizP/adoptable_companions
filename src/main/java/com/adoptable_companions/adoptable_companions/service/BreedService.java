package com.adoptable_companions.adoptable_companions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptable_companions.adoptable_companions.entity.BreedEntity;
import com.adoptable_companions.adoptable_companions.repository.BreedRepository;

@Service
public class BreedService {

    private final BreedRepository breedRepository;

    @Autowired
    public BreedService(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    public List<BreedEntity> findAll() {
        return breedRepository.findAll();
    }

    public Optional<BreedEntity> findById(Integer id) {
        return breedRepository.findById(id);
    }

    public BreedEntity save(BreedEntity breed) {
        return breedRepository.save(breed);
    }

    public void deleteById(Integer id) {
        breedRepository.deleteById(id);
    }
}