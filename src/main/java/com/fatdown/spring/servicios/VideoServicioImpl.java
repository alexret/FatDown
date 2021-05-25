package com.fatdown.spring.servicios;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatdown.spring.entidades.Video;
import com.fatdown.spring.repositorios.VideoPageableRepository;
import com.fatdown.spring.repositorios.VideoRepository;

@Transactional
@Service
public class VideoServicioImpl implements VideoServicio {

	@Autowired
	private VideoPageableRepository videoPageableRepository;

	@Autowired
	private VideoRepository videoRepository;

	@Override
	public Video crearVideo(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public Optional<Video> obtenerVideo(Long idVideo) {
		return videoRepository.findById(idVideo);
	}

	@Override
	public void eliminarVideo(Long idVideo) {
		videoRepository.deleteById(idVideo);
	}

	@Override
	public Page<Video> listarVideosPaginados(Pageable p) {
		return videoPageableRepository.findAll(p);
	}

}
