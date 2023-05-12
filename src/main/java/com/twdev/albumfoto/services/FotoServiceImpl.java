package com.twdev.albumfoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twdev.albumfoto.entities.Foto;
import com.twdev.albumfoto.repository.FotoRepository;

@Service
public class FotoServiceImpl implements FotoService {

	@Autowired
	private FotoRepository repo;
	
	@Override
	public void savarFoto(Foto foto) {
		repo.save(foto);
		
	}

	@Override
	public Foto savarFotoFile(Foto foto) {
		
		return repo.save(foto);
	}

	@Override
	public List<Foto> pegarTodasFotos() {
		
		return repo.findAll();
	}

	@Override
	public Foto pegarFotoId(Long id) {
		
		Optional<Foto> opFoto = repo.findById(id);
		
		Foto foto = null;
		if(opFoto.isPresent()) {
			
			foto = opFoto.get();
		}else {
			throw new RuntimeException("Foto não encontrada");
		}
		
		return foto;
	}

	@Override
	public void deletarFotoId(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Foto atualizarId(long id) {
		
		
		
Optional<Foto> opFoto = repo.findById(id);
		
		Foto foto = null;
		if(opFoto.isPresent()) {
			
			foto = opFoto.get();
		}else {
			throw new RuntimeException("Não foi possível atualizar a foto.");
		}
		
		return  foto;
	}

	@Override
	public Foto fotoSalva(Foto foto) {
		
		return repo.save(foto);
	}

}
