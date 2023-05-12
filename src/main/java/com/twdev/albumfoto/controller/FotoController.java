package com.twdev.albumfoto.controller;

import java.awt.image.LookupOp;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.twdev.albumfoto.entities.Foto;
import com.twdev.albumfoto.entities.Usuario;
import com.twdev.albumfoto.services.FotoService;
import com.twdev.albumfoto.services.FotoServiceImpl;
import com.twdev.albumfoto.services.UsuarioServiceImpl;
import com.twdev.albumfoto.utils.FileUploadUtil;

@Controller
@RequestMapping("/foto")
public class FotoController {
	
	@Autowired
	FotoServiceImpl fotoService;
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	/*
	 *    1º maneira de fazer
	 */	
	@GetMapping("/novo")
	public String novo(Foto foto) {
		return "foto/pagina-cadastrar";  
	}
	
	/* 
	 *  2º maneira de fazer
	 * 
	 * @GetMapping("/novo")
	 *  public String novo(ModelMap map) { Foto foto = new
	 * Foto(); map.addAttribute("foto", foto);
	 * 
	 * List<Usuario> listaUsuario = usuarioService.pegarTodosUsuarios();
	 * map.addAttribute("listaUsuario", listaUsuario);
	 * 
	 * return "foto/pagina-cadastrar"; }
	 */
	
	@PostMapping("/salva")
	public String salva(Foto foto, @RequestParam("image") MultipartFile multipartFile, 
			RedirectAttributes ra) throws IOException {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		foto.setFoto(fileName);
		
		Foto fotoSalva = fotoService.fotoSalva(foto);
		
		String uploadDir = "./fotos-usuario/" + fotoSalva.getId();
		
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		ra.addFlashAttribute("sucesso","foto salva com sucesso!");
		
		System.out.println(fotoSalva.getLegenda() + " - " + uploadDir);
		
		return "redirect:/foto/novo";
	}
	
	@GetMapping("/lista")
	public String listaFotos(ModelMap map) {
		map.addAttribute("listaFotos", fotoService.pegarTodasFotos());
		return "foto/pagina-listar-fotos";
	}
	
	@ModelAttribute("listaUsuario") public List<Usuario> listaUsuarios(){
	  
	  return usuarioService.pegarTodosUsuarios();
	  
	  }
	 
	 
	

}
