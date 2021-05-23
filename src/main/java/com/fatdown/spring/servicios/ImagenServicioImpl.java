package com.fatdown.spring.servicios;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatdown.spring.entidades.Imagen;
import com.fatdown.spring.repositorios.ImagenRepository;

@Transactional
@Service
public class ImagenServicioImpl implements ImagenServicio {

	@Autowired
	private ImagenRepository imagenRepository;
	
	@Override
	public Imagen crearImagen(Imagen imagen) {
		return imagenRepository.save(imagen);
	}

	@Override
	public Optional<Imagen> obtenerImagen(Long idImagen) {
		return imagenRepository.findById(idImagen);
	}

	@Override
	public void eliminarImagen(Long idImagen) {
		imagenRepository.deleteById(idImagen);		
	}

	@Override
	public Iterable<Imagen> listarImagen() {
		return imagenRepository.findAll();
	}

}
