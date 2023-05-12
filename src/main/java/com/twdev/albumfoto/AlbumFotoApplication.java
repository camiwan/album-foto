package com.twdev.albumfoto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twdev.albumfoto.entities.Foto;
import com.twdev.albumfoto.entities.Usuario;
import com.twdev.albumfoto.services.FotoServiceImpl;
import com.twdev.albumfoto.services.UsuarioServiceImpl;

@SpringBootApplication
public class AlbumFotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumFotoApplication.class, args);
	}
     
		
	

}
