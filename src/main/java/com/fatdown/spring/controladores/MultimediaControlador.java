package com.fatdown.spring.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatdown.spring.entidades.Video;
import com.fatdown.spring.servicios.VideoServicio;


@Controller
@RequestMapping(value = "/multimedia")

public class MultimediaControlador {

	@Autowired
	VideoServicio videoServicio;

	@GetMapping("/crearMultimedia")
	public String creaEjericio(Model model, HttpSession session) {
		return "crearMultimedia";
	}

	@PostMapping("/crearVideo")
	public String crearMultimedia(@RequestBody Video video) {
		videoServicio.crearVideo(video);
		return "redirect:/crearMultimedia";
	}

	@PostMapping("/eliminarVideo")
	public String eliminarVideo(Video video) {
		videoServicio.eliminarVideo(video.getIdMultimedia());
		return "redirect:/index";
	}

	@PostMapping("/listarVideos")
	public String listarEjercicios() {
		videoServicio.listarVideo();
		return "redirect:/index";
	}
}
