package com.adoptable_companions.adoptable_companions.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adoptable_companions.adoptable_companions.entity.AnimalEntity;
import com.adoptable_companions.adoptable_companions.service.AnimalService;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // Obtener todos los animales
    @GetMapping
    public List<AnimalEntity> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // Obtener un animal por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAnimalById(@PathVariable(value = "id") Long animalId) {
    	Map<String, Object> response = new HashMap<>();
        Optional<AnimalEntity> animal = animalService.findById(animalId);
        if (!animal.isPresent()) {
        	response.put("mensaje", "El cliente ID: ".concat(animalId.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        AnimalEntity res = animal.get();
        
        return new ResponseEntity<AnimalEntity>(res, HttpStatus.OK);
    }
    
    
    
    // Crear un nuevo animal
    @PostMapping
    public ResponseEntity<?> createAnimal(@Valid @RequestBody AnimalEntity animal) {
		Map<String, Object> response = new HashMap<>();
		try {
			AnimalEntity res =  animalService.save(animal);
			response.put("mensaje", "El animal fue creado correctamente");
			response.put("animales", res);
		}
		catch (Exception e) {
			response.put("errors", e);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    // Actualizar un animal existente
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateAnimal(@PathVariable(value = "id") Long animalId,
            @Valid @RequestBody AnimalEntity animalDetails) {
    	Map<String, Object> response = new HashMap<>();
        Optional<AnimalEntity> animalOp = animalService.findById(animalId);
        if (animalOp == null) {
        	response.put("mensaje", "error al registrar el animal");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        AnimalEntity animal = animalOp.get();
        animal.setNombre(animalDetails.getNombre());
        animal.setChip(animalDetails.getChip());
        animal.setAnioNacimiento(animalDetails.getAnioNacimiento());
        animal.setTipoAnimal(animalDetails.getTipoAnimal());
        animal.setRaza(animalDetails.getRaza());

        
        AnimalEntity updatedAnimal = animalService.save(animal);
    	response.put("mensaje", "El cliente fue creado correctamente");
		response.put("cliente", updatedAnimal);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    // Eliminar un animal existente
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteAnimal(@PathVariable(value = "id") Long animalId) {
    	Map<String, Object> response = new HashMap<>();
        Optional<AnimalEntity> animal = animalService.findById(animalId);
        if (animal == null) {
            return ResponseEntity.notFound().build();
        }
        animalService.deleteById(animal.get().getId());
        
    	response.put("mensaje", "El animal fue dado de baja");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
   
}