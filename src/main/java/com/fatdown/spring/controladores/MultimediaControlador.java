package com.fatdown.spring.controladores;

import javax.servlet.http.HttpSession;

import com.fatdown.spring.entidades.Gif;
import com.fatdown.spring.entidades.Multimedia;
import com.fatdown.spring.servicios.GifServicio;
import javassist.compiler.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fatdown.spring.entidades.Video;
import com.fatdown.spring.servicios.VideoServicio;

import java.util.Optional;


@Controller
@RequestMapping(value = "/multimedia")

public class MultimediaControlador {

	@Autowired
	VideoServicio videoServicio;

	@Autowired
	GifServicio gifServicio;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity getImageAsResponseEntity(@PathVariable String id) {

		try {
			Optional<Gif> optionalMultimedia = gifServicio.obtenerGif(Long.parseLong(id));
			Gif gifObj =  optionalMultimedia.get();
			byte[] media = gifObj.getMultimedia();
			HttpHeaders headers = new HttpHeaders();
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());

			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
			return responseEntity;

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
