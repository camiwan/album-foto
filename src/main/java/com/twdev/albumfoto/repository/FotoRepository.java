package com.twdev.albumfoto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twdev.albumfoto.entities.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {

}
