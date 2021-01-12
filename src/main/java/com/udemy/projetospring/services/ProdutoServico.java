package com.udemy.projetospring.services;

import java.util.List;
import java.util.Optional;

import com.udemy.projetospring.entities.Produto;
import com.udemy.projetospring.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAllProdutos(){
        List<Produto> produtos = repository.findAll();
        return produtos;
    }

    public Produto findProdutoById(Long id){
        Optional<Produto> produto = repository.findById(id);
        return produto.get();
    }
}
