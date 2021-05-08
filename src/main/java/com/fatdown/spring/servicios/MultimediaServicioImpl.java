package com.fatdown.spring.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatdown.spring.entidades.Multimedia;
import com.fatdown.spring.repositorios.MultimediaRepository;

@Transactional
@Service
public class MultimediaServicioImpl implements MultimediaServicio {

	@Autowired
	private MultimediaRepository multimediaRepository;

	@Override
	public Multimedia crearMultimedia(Multimedia multimedia) {
		return multimediaRepository.save(multimedia);
	}

	@Override
	public Multimedia obtenerMultimedia(Long idMultimedia) {
		return multimediaRepository.findById(idMultimedia).orElse(null);
	}

	@Override
	public void eliminarMultimedia(Long idMultimedia) {
		multimediaRepository.deleteById(idMultimedia);

	}

	@Override
	public Iterable<Multimedia> listarMultimedia() {
		return multimediaRepository.findAll();
	}

}
