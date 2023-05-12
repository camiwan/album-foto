package com.twdev.albumfoto.services;

import java.util.List;


import com.twdev.albumfoto.entities.Usuario;

public interface UsuarioService {
	
	void savarUsuario(Usuario usuario);
	Usuario savarFotoUsuarioFile(Usuario usuario);
	List<Usuario> pegarTodosUsuarios();
	Usuario pegarUsuarioId(Long id);
	void deletarUsuarioId(Long id);
	Usuario atualizarId(long id);
	

}
