package com.fatdown.spring.servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fatdown.spring.entidades.Video;

public interface VideoServicio {

	public Video crearVideo(Video video);

	public Optional<Video> obtenerVideo(Long idVideo);

	public void eliminarVideo(Long idVideo);

	public Page<Video> listarVideosPaginados(Pageable p);
}
