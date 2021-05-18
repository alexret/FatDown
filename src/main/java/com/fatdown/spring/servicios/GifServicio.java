package com.fatdown.spring.servicios;

import java.util.Optional;

import com.fatdown.spring.entidades.Gif;
import com.fatdown.spring.entidades.Multimedia;

public interface GifServicio {

	public Gif crearGif(Gif gif);

	public Optional<Multimedia> obtenerGif(Long idGif);

	public void eliminarGif(Long idGif);

	public Iterable<Multimedia> listarGif();

}
