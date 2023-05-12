package com.twdev.albumfoto.services;

import java.util.List;

import com.twdev.albumfoto.entities.Foto;


public interface FotoService {
	
	void savarFoto(Foto foto);
	Foto fotoSalva(Foto foto);
	Foto savarFotoFile(Foto foto);
	List<Foto> pegarTodasFotos();
	Foto pegarFotoId(Long id);
	void deletarFotoId(Long id);
	Foto atualizarId(long id);

}
