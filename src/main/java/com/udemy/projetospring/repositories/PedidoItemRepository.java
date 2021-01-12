package com.udemy.projetospring.repositories;

import com.udemy.projetospring.entities.PedidoItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
    
}
