package com.fatdown.spring.servicios;

import java.util.Optional;

import com.fatdown.spring.entidades.Video;

public interface VideoServicio {

	public Video crearVideo(Video video);

	public Optional<Video> obtenerVideo(Long idVideo);

	public void eliminarVideo(Long idVideo);

	public Iterable<Video> listarVideo();

}
