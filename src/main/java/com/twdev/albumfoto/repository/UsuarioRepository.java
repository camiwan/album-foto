package com.twdev.albumfoto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twdev.albumfoto.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
