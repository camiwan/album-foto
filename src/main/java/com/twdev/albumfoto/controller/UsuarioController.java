package com.twdev.albumfoto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.twdev.albumfoto.entities.Foto;
import com.twdev.albumfoto.entities.Usuario;
import com.twdev.albumfoto.services.FotoServiceImpl;
import com.twdev.albumfoto.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@Autowired
	FotoServiceImpl fotoService;
	
	@GetMapping("/novo")
	public String novo(ModelMap map) {
		
		map.addAttribute("mensagemNovoCadastro", "Novo Cadastro");
		
		return "usuario/pagina-cadastrar";
	}
	
	@PostMapping("/salva")
	public String salva(Usuario usuario, RedirectAttributes ra) {
		
		usuarioService.savarUsuario(usuario);
		ra.addFlashAttribute("sucesso","Usuario salvo com sucesso!");
		
		return "redirect:/usuario/novo";
	}
	
	@GetMapping("/lista")	
	public String listaUsuarios(ModelMap map) {
			
		List<Usuario> usuarios = usuarioService.pegarTodosUsuarios();
		Foto fotos = new Foto();
		 
		map.addAttribute("usuarios", usuarios);
		map.addAttribute("fotos", fotos);
		map.addAttribute("lista","Lista de Usuários Cadastrados");
				
		return "usuario/pagina-listar";
		
		
		
	}
}

