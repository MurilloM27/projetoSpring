package com.udemy.projetospring.repositories;

import com.udemy.projetospring.entities.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
