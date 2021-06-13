package com.fatdown.spring.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

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

	// ManyToMany Usuario - poseída
	@ManyToMany
	(mappedBy = "videos", fetch = FetchType.EAGER)
	private Set<Usuario> usuarios;

	// Constructores

	public Video() {
		super();
	}

	public Video(long idMultimedia, String nombreMultimedia, Categoria categoriaVideo,
			String linkVideo, Set<Usuario> usuarios) {
		super(idMultimedia, nombreMultimedia);
		this.categoriaVideo = categoriaVideo;
		this.linkVideo = linkVideo;
		this.usuarios = usuarios;

	}

	public Video(String nombreMultimedia, Categoria categoriaVideo, String linkVideo,
			Set<Usuario> usuarios) {
		super(nombreMultimedia);
		this.categoriaVideo = categoriaVideo;
		this.linkVideo = linkVideo;
		this.usuarios = usuarios;

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

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuario) {
		usuarios = usuario;
	}
	
	public void anadirUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		usuario.getVideos().add(this);
	}
	
	public void deleteUsuario(Usuario usuario) {
		this.usuarios.remove(usuario) ;
	}

}
