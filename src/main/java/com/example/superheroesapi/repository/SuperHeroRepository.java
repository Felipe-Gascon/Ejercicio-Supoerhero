package com.example.superheroesapi.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.superheroesapi.entity.SuperHero;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {
	Page<SuperHero> findByNameContainingIgnoreCase(String name, Pageable pageable);

	Page<SuperHero> findAll(Pageable pageable);
}