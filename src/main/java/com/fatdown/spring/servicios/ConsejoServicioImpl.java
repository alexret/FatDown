package com.fatdown.spring.servicios;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatdown.spring.entidades.Consejo;
import com.fatdown.spring.repositorios.ConsejoRepository;

@Transactional
@Service
public class ConsejoServicioImpl implements ConsejoServicio {

	@Autowired
	private ConsejoRepository consejoRepository;

	@Override
	public Consejo crearConsejo(Consejo consejo) {
		return consejoRepository.save(consejo);
	}

	@Override
	public Optional<Consejo> obtenerConsejo(Long idConsejo) {
		return consejoRepository.findById(idConsejo);
	}

	@Override
	public void eliminarConsejo(Long idConsejo) {
		consejoRepository.deleteById(idConsejo);
	}

	@Override
	public Iterable<Consejo> listarConsejo() {
		return consejoRepository.findAll();
	}

}
