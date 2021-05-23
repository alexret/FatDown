package com.fatdown.spring.servicios;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatdown.spring.entidades.Gif;
import com.fatdown.spring.entidades.Multimedia;
import com.fatdown.spring.repositorios.GifRepository;

@Transactional
@Service
public class GifServicioImpl implements GifServicio {
	
	@Autowired
	private GifRepository gifRepository;

	@Override
	public Gif crearGif(Gif gif) {
		return gifRepository.save(gif);
	}

	@Override
	public Optional<Gif> obtenerGif(Long idGif) {

		return gifRepository.findById(idGif);
	}

	@Override
	public void eliminarGif(Long idGif) {
		gifRepository.deleteById(idGif);		
	}

	@Override
	public Iterable<Gif> listarGif() {
		return gifRepository.findAll();
	}

}
