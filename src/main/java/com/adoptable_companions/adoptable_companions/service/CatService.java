package com.adoptable_companions.adoptable_companions.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptable_companions.adoptable_companions.entity.CatEntity;
import com.adoptable_companions.adoptable_companions.repository.CatRepository;

@Service
public class CatService {
	@Autowired
	CatRepository repositoryCat;
	
	public List<CatEntity> getAllCats() {
		List<CatEntity> cats = new ArrayList<>();
		cats = repositoryCat.findAll();
		return cats;
	}
}
