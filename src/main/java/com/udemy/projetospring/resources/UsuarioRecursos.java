package com.udemy.projetospring.resources;

import java.net.URI;
import java.util.List;

import com.udemy.projetospring.entities.Usuario;
import com.udemy.projetospring.services.UsuarioServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping
    public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario){
        usuario = servico.adicionarUsuario(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }
}
