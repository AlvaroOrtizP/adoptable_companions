package com.adoptable_companions.adoptable_companions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptable_companions.adoptable_companions.entity.AnimalEntity;
import com.adoptable_companions.adoptable_companions.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<AnimalEntity> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<AnimalEntity> findById(Long animalId) {
        return animalRepository.findById(animalId);
    }

    public AnimalEntity save(AnimalEntity animal) {
        return animalRepository.save(animal);
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }
}