package com.udemy.projetospring.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.udemy.projetospring.entities.Usuario;
import com.udemy.projetospring.repositories.UsuarioRepository;
import com.udemy.projetospring.services.exceptions.DatabaseException;
import com.udemy.projetospring.services.exceptions.RecursoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontradoException(id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

	public Usuario atualizar(Long id, Usuario usuario) {
        try {
            Usuario user = usuarioRepository.getOne(id);
            atualizarUser(user, usuario);
            return usuarioRepository.save(user);       
        } catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontradoException(id);
        }
    }

    private void atualizarUser(Usuario user, Usuario usuario) {
        user.setNome(usuario.getNome());
        user.setEmail(usuario.getEmail());
        user.setTelefone(usuario.getTelefone());
    }

}
