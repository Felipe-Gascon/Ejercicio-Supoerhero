package com.example.superheroesapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.superheroesapi.entity.SuperHero;
import com.example.superheroesapi.repository.SuperHeroRepository;

@Service
public class SuperHeroService {
	
	    private final SuperHeroRepository superHeroRepository;

	    @Autowired
	    public SuperHeroService(SuperHeroRepository superHeroRepository) {
	        this.superHeroRepository = superHeroRepository;
	    }
	    
	    @Cacheable(value = "superHeroesCache")
	    public Page<SuperHero> findAll(Pageable pageable) {
	        return superHeroRepository.findAll(pageable);
	    }
	    
	    @Cacheable(value = "superHeroesCache", key = "#id")
	    public Optional<SuperHero> findById(Long id) {
	        return superHeroRepository.findById(id);
	    }

	    public Page<SuperHero> findByNameContaining(String name, Pageable pageable) {
	        return superHeroRepository.findByNameContainingIgnoreCase(name, pageable);
	    }

	    public SuperHero save(SuperHero superHero) {
	        return superHeroRepository.save(superHero);
	    }

	    public void update(SuperHero superHero) {
	        if (superHero.getId() != null && superHeroRepository.existsById(superHero.getId())) {
	            superHeroRepository.save(superHero);
	        }
	    }

	    public void deleteById(Long id) {
	        superHeroRepository.deleteById(id);
	    }
	}