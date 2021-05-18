package com.fatdown.spring.servicios;

import java.util.Optional;

import com.fatdown.spring.entidades.Imagen;
import com.fatdown.spring.entidades.Multimedia;

public interface ImagenServicio {

	public Imagen crearImagen(Imagen imagen);

	public Optional<Multimedia> obtenerImagen(Long idImagen);

	public void eliminarImagen(Long idImagen);

	public Iterable<Multimedia> listarImagen();

}
