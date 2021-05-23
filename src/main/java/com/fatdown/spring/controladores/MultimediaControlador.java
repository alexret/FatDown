package com.fatdown.spring.controladores;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fatdown.spring.entidades.Gif;
import com.fatdown.spring.entidades.Imagen;
import com.fatdown.spring.entidades.Video;
import com.fatdown.spring.servicios.GifServicio;
import com.fatdown.spring.servicios.ImagenServicio;
import com.fatdown.spring.servicios.VideoServicio;

@Controller
@RequestMapping(value = "/multimedia")

public class MultimediaControlador {

	@Autowired
	VideoServicio videoServicio;

	@Autowired
	GifServicio gifServicio;

	@Autowired
	ImagenServicio imagenServicio;

	// Método página para subir videos, gifs o imágenes

	@GetMapping("/crearMultimedia")
	public String creaEjericio(Model model, HttpSession session) {
		return "crearMultimedia";
	}

	// Métodos de Video

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
	public String listarVideos() {
		videoServicio.listarVideo();
		return "redirect:/index";
	}

	// Métodos de Imagen

	@PostMapping("/crearImagen")
	public String crearMultimedia(@RequestBody Imagen imagen) {
		imagenServicio.crearImagen(imagen);
		return "redirect:/crearMultimedia";
	}

	@PostMapping("/eliminarImagen")
	public String eliminarImagen(Imagen imagen) {
		imagenServicio.eliminarImagen(imagen.getIdMultimedia());
		return "redirect:/index";
	}

	@PostMapping("/listarImagenes")
	public String listarImagenes() {
		imagenServicio.listarImagen();
		return "redirect:/index";
	}

	// Obtener Imagen de BBDD
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public @ResponseBody ResponseEntity getImageAsResponseEntity(@PathVariable String id) {

			try {
				Optional<Imagen> optionalMultimedia = imagenServicio.obtenerImagen(Long.parseLong(id));
				Imagen imagenObj = optionalMultimedia.get();
				byte[] media = imagenObj.getMultimedia();
				HttpHeaders headers = new HttpHeaders();
				headers.setCacheControl(CacheControl.noCache().getHeaderValue());

				ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
				return responseEntity;

			} catch (Exception e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
	}

	// Métodos de Gif

	@PostMapping("/crearGif")
	public String crearGif(@RequestBody Gif gif) {
		gifServicio.crearGif(gif);
		return "redirect:/crearMultimedia";
	}

	@PostMapping("/eliminarGif")
	public String eliminarGif(Gif gif) {
		gifServicio.eliminarGif(gif.getIdMultimedia());
		return "redirect:/index";
	}

	@PostMapping("/listarGifs")
	public String listarGifs() {
		gifServicio.listarGif();
		return "redirect:/index";
	}

	// Obtener Gif de BBDD
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity getGifAsResponseEntity(@PathVariable String id) {

		try {
			Optional<Gif> optionalMultimedia = gifServicio.obtenerGif(Long.parseLong(id));
			Gif gifObj = optionalMultimedia.get();
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
