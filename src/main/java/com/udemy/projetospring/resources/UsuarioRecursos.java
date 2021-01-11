package com.udemy.projetospring.resources;

import com.udemy.projetospring.entities.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsuarioRecursos {
    
    @GetMapping
    public ResponseEntity<Usuario> listarUsuarios(){
        Usuario usuario = new Usuario(1L, "João", "joao@gmail.com", "999999", "123456");
        return ResponseEntity.ok().body(usuario);
    }

}
