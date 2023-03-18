package com.adoptable_companions.adoptable_companions.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cat")
public class CatEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cat_id")
	private Integer catId;
	@Column(name = "name")
	private String name;
	@Column(name = "chip_id")
	private String chipId;
	@Column(name = "race")
	private String race;
	public CatEntity(Integer catId, String name, String chipId, String race) {
		super();
		this.catId = catId;
		this.name = name;
		this.chipId = chipId;
		this.race = race;
	}
	public CatEntity() {

	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChipId() {
		return chipId;
	}
	public void setChipId(String chipId) {
		this.chipId = chipId;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	
	
	
}
