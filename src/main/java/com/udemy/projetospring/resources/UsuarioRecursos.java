package com.udemy.projetospring.resources;

import java.util.List;

import com.udemy.projetospring.entities.Usuario;
import com.udemy.projetospring.services.UsuarioServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsuarioRecursos {
    
    @Autowired
    private UsuarioServico servico;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = servico.findAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping(value = "/{id}")
    public Usuario listarPorId(@PathVariable Long id){
        return servico.findById(id);
    }
}
