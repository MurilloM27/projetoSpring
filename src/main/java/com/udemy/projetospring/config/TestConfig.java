package com.udemy.projetospring.config;

import java.util.Arrays;

import com.udemy.projetospring.entities.Usuario;
import com.udemy.projetospring.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
       
        Usuario usuario = new Usuario(null, "João", "joao@gmail.com", "999778844", "123456");
        Usuario usuario2 = new Usuario(null, "Maria", "maria@gmail.com", "988775522", "654321");

        usuarioRepository.saveAll(Arrays.asList(usuario, usuario2));
    }


}
