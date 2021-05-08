package com.fatdown.spring.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatdown.spring.entidades.Multimedia;
import com.fatdown.spring.servicios.MultimediaServicio;

@Controller
@RequestMapping(value = "/multimedia")

public class MultimediaControlador {

	@Autowired
	MultimediaServicio multimediaServicio;

	@PostMapping("/crearMultimedia")
	public String crearMultimedia(@Valid @RequestBody Multimedia multimedia) {
		multimediaServicio.crearMultimedia(multimedia);
		return "redirect:/crearMultimedia";
	}

}