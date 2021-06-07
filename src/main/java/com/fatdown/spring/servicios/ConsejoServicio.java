package com.fatdown.spring.servicios;

import java.util.Optional;

import com.fatdown.spring.entidades.Consejo;

public interface ConsejoServicio {
	
	public Consejo crearConsejo(Consejo consejo);

	public Optional<Consejo> obtenerConsejo(Long idConsejo);

	public void eliminarConsejo(Long idConsejo);

	public Iterable<Consejo> listarConsejo();

}
