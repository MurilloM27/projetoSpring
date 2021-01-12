package com.udemy.projetospring.resources;

import java.util.List;

import com.udemy.projetospring.entities.Pedido;
import com.udemy.projetospring.services.PedidoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class PedidoResources {
    
    @Autowired
    private PedidoServico servico;

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        List<Pedido> listaPedidos = servico.listar();
        return ResponseEntity.ok().body(listaPedidos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> pedidoPorId(@PathVariable Long id){
        Pedido pedido = servico.listarId(id);
        return ResponseEntity.ok().body(pedido);
    }
    
}
