package com.twdev.albumfoto;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.twdev.albumfoto.entities.Foto;
import com.twdev.albumfoto.entities.Usuario;
import com.twdev.albumfoto.services.FotoServiceImpl;
import com.twdev.albumfoto.services.UsuarioServiceImpl;

@SpringBootTest
class AlbumFotoApplicationTests {

	
	
	@Autowired
	
	UsuarioServiceImpl usuarioService;
	
	@Autowired
	FotoServiceImpl fotoService;
	
	@Test
	void contextLoads() {
		
		for (Usuario u : usuarioService.pegarTodosUsuarios()) {

			System.out.println(u.getNome());
			
				for(Foto f : u.getFotos()) {
				
				System.out.println(f.getFoto());
			}
			
			
		
		}
		
	}
		
		
	
}
