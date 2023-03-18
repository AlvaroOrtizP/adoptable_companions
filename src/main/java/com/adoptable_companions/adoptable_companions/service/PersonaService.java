package com.adoptable_companions.adoptable_companions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptable_companions.adoptable_companions.entity.PersonaEntity;
import com.adoptable_companions.adoptable_companions.repository.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
    private PersonaRepository personaRepository;

    public List<PersonaEntity> findAll() {
        return personaRepository.findAll();
    }

    public Optional<PersonaEntity> findById(Integer id) {
        return personaRepository.findById(id);
    }

    public PersonaEntity save(PersonaEntity person) {
        return personaRepository.save(person);
    }

    public void deleteById(Integer id) {
    	personaRepository.deleteById(id);
    }
}

