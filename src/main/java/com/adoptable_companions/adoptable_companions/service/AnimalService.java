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

    public List<AnimalEntity> findAll() {
        return animalRepository.findAll();
    }

    public Optional<AnimalEntity> findById(Integer id) {
        return animalRepository.findById(id);
    }

    public AnimalEntity save(AnimalEntity animal) {
        return animalRepository.save(animal);
    }

    public void deleteById(Integer id) {
        animalRepository.deleteById(id);
    }
}