package com.udemy.projetospring.repositories;

import com.udemy.projetospring.entities.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
