package com.adoptable_companions.adoptable_companions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptable_companions.adoptable_companions.entity.AdopcionEntity;
import com.adoptable_companions.adoptable_companions.repository.AdopcionRepository;

@Service
public class AdopcionService {

    private final AdopcionRepository adopcionRepository;

    @Autowired
    public AdopcionService(AdopcionRepository adopcionRepository) {
        this.adopcionRepository = adopcionRepository;
    }

    public List<AdopcionEntity> findAll() {
        return adopcionRepository.findAll();
    }

    public Optional<AdopcionEntity> findById(Integer id) {
        return adopcionRepository.findById(id);
    }

    public AdopcionEntity save(AdopcionEntity adopcion) {
        return adopcionRepository.save(adopcion);
    }

    public void deleteById(Integer id) {
        adopcionRepository.deleteById(id);
    }
}
