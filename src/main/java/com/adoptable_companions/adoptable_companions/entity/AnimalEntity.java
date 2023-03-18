package com.adoptable_companions.adoptable_companions.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "animales")
public class AnimalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	private String chip;

	@Column(name = "anio_nacimiento")
	private Integer anioNacimiento;

	@Enumerated(EnumType.STRING)
	private TipoAnimal tipoAnimal;

	@ManyToOne
	@JoinColumn(name = "id_raza")
	private BreedEntity raza;

	public enum TipoAnimal {
		PERRO, GATO, CONEJO, PAJARO, OTROS
	}

	// constructores, getters y setters
	public AnimalEntity(String nombre, String chip, Integer anioNacimiento, TipoAnimal tipoAnimal, BreedEntity raza) {
		super();
		this.nombre = nombre;
		this.chip = chip;
		this.anioNacimiento = anioNacimiento;
		this.tipoAnimal = tipoAnimal;
		this.raza = raza;
	}

	public AnimalEntity() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public Integer getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(Integer anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public BreedEntity getRaza() {
		return raza;
	}

	public void setRaza(BreedEntity raza) {
		this.raza = raza;
	}

}