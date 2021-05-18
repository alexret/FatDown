package com.fatdown.spring.servicios;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatdown.spring.entidades.Multimedia;
import com.fatdown.spring.entidades.Video;
import com.fatdown.spring.repositorios.VideoRepository;

@Transactional
@Service
public class VideoServicioImpl implements VideoServicio {
	
	@Autowired
	private VideoRepository videoRepository;

	@Override
	public Video crearVideo(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public Optional<Multimedia> obtenerVideo(Long idVideo) {
		return videoRepository.findById(idVideo);
	}

	@Override
	public void eliminarVideo(Long idVideo) {
		videoRepository.deleteById(idVideo);		
	}

	@Override
	public Iterable<Multimedia> listarVideo() {
		return videoRepository.findAll();
	}

}
