package com.udemy.projetospring.services;

import java.util.List;
import java.util.Optional;

import com.udemy.projetospring.entities.Usuario;
import com.udemy.projetospring.repositories.UsuarioRepository;
import com.udemy.projetospring.services.exceptions.RecursoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServico {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new RecursoNaoEncontradoException(id));
    }

    public Usuario adicionarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

	public Usuario atualizar(Long id, Usuario usuario) {
        Usuario user = usuarioRepository.getOne(id);
        atualizarUser(user, usuario);
        return usuarioRepository.save(user);
	}

    private void atualizarUser(Usuario user, Usuario usuario) {
        user.setNome(usuario.getNome());
        user.setEmail(usuario.getEmail());
        user.setTelefone(usuario.getTelefone());
    }

}
