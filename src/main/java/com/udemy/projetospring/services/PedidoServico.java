package com.udemy.projetospring.services;

import java.util.List;
import java.util.Optional;

import com.udemy.projetospring.entities.Pedido;
import com.udemy.projetospring.repositories.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoServico {
    
    @Autowired
    private PedidoRepository repository;

    public List<Pedido> listar(){
        return repository.findAll();
    }

    public Pedido listarId(Long id){
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.get();
    }
}
