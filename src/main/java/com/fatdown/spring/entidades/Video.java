package com.fatdown.spring.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fatdown.spring.enums.Categoria;

//An entity cannot be annotated with both @Entity and @MappedSuperclass
//@MappedSuperclass
@Entity
public class Video extends Multimedia {

	private static final long serialVersionUID = 7337585826428548113L;

	/*
	 * Enumerated Esta anotación indica que la propiedad Java es un enumerado
	 * EnumType Este atributo indica cómo se debe persistir en la base de datos el
	 * enumerado. Sus posible valores son: ORDINAL: Se almacenará en la base de
	 * datos el ordinal del enumerado. STRING: Se almacenará en la base de datos el
	 * nombre del enumerado.
	 */

	@Column(name = "CATEGORIA_VIDEO")
	@Enumerated(EnumType.ORDINAL)
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

	public Video(long idMultimedia, String nombreMultimedia, byte[] multimedia, Categoria categoriaVideo,
			String linkVideo, Usuario usuario) {
		super(idMultimedia, nombreMultimedia, multimedia);
		this.categoriaVideo = categoriaVideo;
		this.linkVideo = linkVideo;
		this.usuario = usuario;

	}

	public Video(String nombreMultimedia, byte[] multimedia, Categoria categoriaVideo, String linkVideo,
			Usuario usuario) {
		super(nombreMultimedia, multimedia);
		this.categoriaVideo = categoriaVideo;
		this.linkVideo = linkVideo;
		this.usuario = usuario;

	}

	public Video(String nombreMultimedia, Categoria categoriaVideo, String linkVideo) {
		super(nombreMultimedia);
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
