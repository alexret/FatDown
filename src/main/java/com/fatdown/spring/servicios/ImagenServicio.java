package com.fatdown.spring.servicios;

import java.util.Optional;

import com.fatdown.spring.entidades.Imagen;

public interface ImagenServicio {

	public Imagen crearImagen(Imagen imagen);

	public Optional<Imagen> obtenerImagen(Long idImagen);

	public void eliminarImagen(Long idImagen);

	public Iterable<Imagen> listarImagen();

}
