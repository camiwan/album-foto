package com.twdev.albumfoto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(ModelMap map) {
		map.addAttribute("mensagemBemVindo", "BEM VINDO(A)!!");
		
		return "home/index";
			
	}

}
