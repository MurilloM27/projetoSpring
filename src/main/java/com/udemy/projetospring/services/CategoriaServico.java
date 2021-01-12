package com.udemy.projetospring.services;

import java.util.List;
import java.util.Optional;

import com.udemy.projetospring.entities.Categoria;
import com.udemy.projetospring.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaServico {
    
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listarCategorias(){
        return repository.findAll();
    }

    public Categoria categoriaPorId(Long id){
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.get();
    }
}
