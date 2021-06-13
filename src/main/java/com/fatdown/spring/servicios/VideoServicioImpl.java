package com.fatdown.spring.servicios;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatdown.spring.entidades.Usuario;
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
	public Video obtenerVideo(Long idVideo) {
		return videoRepository.findById(idVideo).orElse(null);
	}

	@Override
	public void eliminarVideo(Long idVideo) {
		videoRepository.deleteById(idVideo);
	}

	@Override
	public Page<Video> listarVideosPaginados(Pageable p) {
		return videoPageableRepository.findAll(p);
	}

	@Override
	public Set<Video> listarVideosUsuario(Usuario usuario) {
		Iterable videos= videoRepository.findAll();
		
		Iterator<Video> it = videos.iterator();
		
		Set <Video> buscados = new HashSet();

		// Buscamos los videos donde se contenga un usuario con el id buscado y se agregan al nuevo set
		while (it.hasNext()) {
			Video aux = it.next();
			if (aux.getUsuarios().contains(usuario))
				buscados.add(aux);				
		}		
		
		return buscados;
	}

}
