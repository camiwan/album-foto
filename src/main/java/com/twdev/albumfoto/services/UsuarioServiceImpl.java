package com.twdev.albumfoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twdev.albumfoto.entities.Foto;
import com.twdev.albumfoto.entities.Usuario;
import com.twdev.albumfoto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository repo;
	
	@Override
	public void savarUsuario(Usuario usuario) {
		
		repo.save(usuario);
		
	}

	@Override
	public Usuario savarFotoUsuarioFile(Usuario usuario) {
		
		return repo.save(usuario);
	}

	@Override
	public List<Usuario> pegarTodosUsuarios() {
		
		return repo.findAll();
	}

	@Override
	public Usuario pegarUsuarioId(Long id) {
		Optional<Usuario> opUsuario = repo.findById(id);
		Usuario usuario = null;
		if(opUsuario.isPresent()) {
			usuario = opUsuario.get();
		}else {
			throw new RuntimeException("Ops! Usuário não encontrado.");
		}
		return usuario;
	}

	@Override
	public void deletarUsuarioId(Long id) {
		
		repo.deleteById(id);
		
	}

	@Override
	public Usuario atualizarId(long id) {
		Optional<Usuario> opUsuario = repo.findById(id);
		Usuario usuario = null;
		if(opUsuario.isPresent()) {
			
			usuario = opUsuario.get();
		}
		return usuario;
	}

	

	

}
