package com.udemy.projetospring.resources;

import java.util.List;

import com.udemy.projetospring.entities.Categoria;
import com.udemy.projetospring.services.CategoriaServico;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoriaRecursos {
    
    private CategoriaServico servico;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        List<Categoria> listaCategorias = servico.listarCategorias();
        return ResponseEntity.ok().body(listaCategorias);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> listarPorId(@PathVariable Long id){
        Categoria categoria = servico.categoriaPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

}
