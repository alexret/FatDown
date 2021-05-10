package com.fatdown.spring.controladores;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.entidades.Multimedia;
import com.fatdown.spring.servicios.MultimediaServicio;

@Controller
@RequestMapping(value = "/multimedia")

public class MultimediaControlador {

	@Autowired
	MultimediaServicio multimediaServicio;

	@GetMapping("/crearMultimedia")
	public String creaEjericio(Model model, HttpSession session) {
		return "multimedia/crearMultimedia";
	}

	@PostMapping("/crearMultimedia")
	public String crearMultimedia(@Valid @RequestBody Multimedia multimedia) {
		multimediaServicio.crearMultimedia(multimedia);
		return "redirect:/crearMultimedia";
	}

	@PostMapping("/eliminarEjercicio")
	public String eliminarEjercicio(@Valid Multimedia multimedia) {
		multimediaServicio.eliminarMultimedia(multimedia.getIdMultimedia());
		return "redirect:/index";
	}

	@PostMapping("/listarEjercicios")
	public String listarEjercicios() {
		multimediaServicio.listarMultimedia();
		return "redirect:/index";
	}
}
