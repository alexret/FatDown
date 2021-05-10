package com.fatdown.spring.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fatdown.spring.enums.Categoria;

//An entity cannot be annotated with both @Entity and @MappedSuperclass
//@MappedSuperclass
@Entity
public class Video extends Multimedia {

	private static final long serialVersionUID = 7337585826428548113L;

	@Column(name = "CATEGORIA_VIDEO")
	private Categoria categoriaVideo;

	@Column(name = "LINK_VIDEO")
	private String linkVideo;

	// OneToMany Usuario - poseída
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	// Constructores

	public Video() {
		super();
	}

	public Video(long idMultimedia, String nombreMultimedia, Categoria categoriaVideo, String linkVideo) {
		super();

		this.categoriaVideo = categoriaVideo;
		this.linkVideo = linkVideo;
	}

	public Video(String nombreMultimedia, Categoria categoriaVideo, String linkVideo) {
		super();
		this.categoriaVideo = categoriaVideo;
		this.linkVideo = linkVideo;
	}

	// Métodos

	public Categoria getCategoriaVideo() {
		return categoriaVideo;
	}

	public void setCategoriaVideo(Categoria categoriaVideo) {
		this.categoriaVideo = categoriaVideo;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
