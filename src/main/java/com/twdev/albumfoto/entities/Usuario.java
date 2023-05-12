package com.twdev.albumfoto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_usuarios")
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", nullable = false, length = 40)
	private String nome;
	
	@Column(name = "email", nullable = false, unique = true, length = 60)
	private String email;
	
	@Column(name = "senha", nullable = false, length = 60)
	private String senha;
	
	@OneToMany(mappedBy = "usuario", orphanRemoval = true, fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.ALL)
	private List<Foto> fotos= new ArrayList<>();
	
	public Usuario() {}
	
	public Usuario(String nome, String email, String senha, List<Foto> fotos) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.fotos = fotos;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	
	
	@Transient
	public String getFotosImagePath() {
				
		if(fotos == null ||  id == null) return null;
		
		return "/fotos-usuario/" + id + "/" + fotos;
	}

	@Override
	public String toString() {
		return fotos +  getFotosImagePath();
	}
	
	
	

}
