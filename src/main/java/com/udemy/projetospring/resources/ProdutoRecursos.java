package com.udemy.projetospring.resources;

import java.util.List;

import com.udemy.projetospring.entities.Produto;
import com.udemy.projetospring.services.ProdutoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProdutoRecursos {
    
    @Autowired
    private ProdutoServico servico;

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = servico.findAllProdutos();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> listarProdutoPorId(@PathVariable Long id){
        Produto produtoById = servico.findProdutoById(id);
        return ResponseEntity.ok().body(produtoById);
    }
}
