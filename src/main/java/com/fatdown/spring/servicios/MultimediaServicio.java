package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Multimedia;

public interface MultimediaServicio {
	
	public Multimedia crearMultimedia(Multimedia multimedia);
	
	public Multimedia obtenerMultimedia (Long idMultimedia);	
	
	public void eliminarMultimedia (Long idMultimedia);
	
	public Iterable<Multimedia> listarMultimedia ();

}
