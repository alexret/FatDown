package com.fatdown.spring.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import com.fatdown.spring.enums.Categoria;

@MappedSuperclass
@Entity

public class Video extends Multimedia {

	private static final long serialVersionUID = 7337585826428548113L;

	@Column(name = "CATEGORIA_VIDEO")
	private Categoria categoriaVideo;

	@Column(name = "LINK_VIDEO")
	private String linkVideo;

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

	// Metodos

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

}
