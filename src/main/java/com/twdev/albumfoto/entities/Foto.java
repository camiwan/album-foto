package com.twdev.albumfoto.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_fotos")
public class Foto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true, length = 64)
	private String foto;
	
	@Column(name="legenda", nullable = false, length = 40)
	private String legenda;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_foto", nullable = false, columnDefinition = "DATE")
	private LocalDate dataFoto;
	
	@Column(name="descricao", nullable = false, length = 100)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_fk", nullable = false)
	private Usuario usuario;

	public Foto() {}
	public Foto(String foto, String legenda, LocalDate dataFoto, String descricao, Usuario usuario) {
		this.foto = foto;
		this.legenda = legenda;
		this.dataFoto = dataFoto;
		this.descricao = descricao;
		this.usuario = usuario;
	}
	public Long getId() {
		return id;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getLegenda() {
		return legenda;
	}
	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}
	public LocalDate getDataFoto() {
		return dataFoto;
	}
	public void setDataFoto(LocalDate dataFoto) {
		this.dataFoto = dataFoto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
		
	@Override
	public String toString() {
		return foto + getFoto() + getFotosImagePath();  
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(foto, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foto other = (Foto) obj;
		return Objects.equals(foto, other.foto) && Objects.equals(id, other.id);
	}
	@Transient
	public String getFotosImagePath() {
		
		
		if(foto == null ||  id == null) return null;
		
		return "/fotos-usuario/" + id + "/" + foto;
	}
	
	
		
	
}
