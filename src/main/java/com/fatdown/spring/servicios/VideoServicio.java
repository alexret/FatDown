package com.fatdown.spring.servicios;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fatdown.spring.entidades.Usuario;
import com.fatdown.spring.entidades.Video;

public interface VideoServicio {

	public Video crearVideo(Video video);

	public Video obtenerVideo(Long idVideo);

	public void eliminarVideo(Long idVideo);
	
	public Set<Video> listarVideosUsuario(Usuario usuario);

	public Page<Video> listarVideosPaginados(Pageable p);
}
