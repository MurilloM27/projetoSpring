package com.udemy.projetospring.repositories;

import com.udemy.projetospring.entities.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
}
