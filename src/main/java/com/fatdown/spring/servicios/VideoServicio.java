package com.fatdown.spring.servicios;

import java.util.Optional;

import com.fatdown.spring.entidades.Multimedia;
import com.fatdown.spring.entidades.Video;

public interface VideoServicio {

	public Video crearVideo(Video video);

	public Optional<Multimedia> obtenerVideo(Long idVideo);

	public void eliminarVideo(Long idVideo);

	public Iterable<Multimedia> listarVideo();

}
