package com.example.superheroesapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.superheroesapi.entity.SuperHero;
import com.example.superheroesapi.repository.SuperHeroRepository;

class SuperHeroServiceTest {
	 	@Mock
	    private SuperHeroRepository superHeroRepository;

	    @InjectMocks
	    private SuperHeroService superHeroService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void whenFindAllWithPagination_thenReturnsPageOfSuperHeroes() {
	        // Preparación
	        SuperHero batman = new SuperHero(1L, "Batman");
	        SuperHero superman = new SuperHero(2L, "Superman");
	        List<SuperHero> superHeroes = Arrays.asList(batman, superman);
	        Page<SuperHero> expectedPage = new PageImpl<>(superHeroes);
	        Pageable pageable = PageRequest.of(0, 2);

	        // Mockeo
	        when(superHeroRepository.findAll(pageable)).thenReturn(expectedPage);

	        // Acción
	        Page<SuperHero> resultPage = superHeroService.findAll(pageable);

	        // Verificación
	        assertThat(resultPage.getContent()).hasSize(2);
	        assertThat(resultPage.getContent()).extracting(SuperHero::getName).containsExactly("Batman", "Superman");

	        // Verificar interacción con el repositorio
	        verify(superHeroRepository).findAll(pageable);
	    }
	}
