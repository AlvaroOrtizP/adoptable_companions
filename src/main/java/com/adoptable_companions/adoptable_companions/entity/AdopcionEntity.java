package com.adoptable_companions.adoptable_companions.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "adopciones")
public class AdopcionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private PersonaEntity persona;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    private AnimalEntity animal;

    @Column(name = "fecha_adopcion")
    @Temporal(TemporalType.DATE)
    private Date fechaAdopcion;

    @Column(name = "estado_actual")
    private String estadoActual;

    
    // constructores, getters y setters
    
    
	public AdopcionEntity(PersonaEntity persona, AnimalEntity animal, Date fechaAdopcion, String estadoActual) {
		super();
		this.persona = persona;
		this.animal = animal;
		this.fechaAdopcion = fechaAdopcion;
		this.estadoActual = estadoActual;
	}
	public AdopcionEntity() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

	public AnimalEntity getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalEntity animal) {
		this.animal = animal;
	}

	public Date getFechaAdopcion() {
		return fechaAdopcion;
	}

	public void setFechaAdopcion(Date fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
	}

	public String getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}


    
    
}