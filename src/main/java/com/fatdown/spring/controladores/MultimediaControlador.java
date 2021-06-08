package com.fatdown.spring.controladores;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.servlet.ModelAndView;

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

	// Método página para subir videos

	@GetMapping("/subirVideo")
	public String creaVideo(Model model, HttpSession session) {
		return "subirVideo";
	}

	// Métodos de Video

	@PostMapping("/crearVideo")
	public String crearVideo(Video video, HttpServletRequest request) {

		videoServicio.crearVideo(video);
		return "redirect:/index";
	}

	@PostMapping("/eliminarVideo/{id}")
    public String eliminarVideo(@PathVariable("id") long id) {
        videoServicio.eliminarVideo(id);
        return "redirect:/index";
    }

	@GetMapping("/listarVideos")
    public ModelAndView listarVideos() {
        ModelAndView mav = new ModelAndView();
        Pageable paging = PageRequest.of(0,10);
        Page<Video> lVideos = videoServicio.listarVideosPaginados(paging);

        mav.addObject("video", lVideos);
        mav.setViewName("/listarVideos");
        return mav;
    }

	// Métodos de Imagen

	@PostMapping("/crearImagen")
	public String crearMultimedia(@RequestBody Imagen imagen) {
		imagenServicio.crearImagen(imagen);
		return "redirect:/index";
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

	
	// Métodos de Gif

	@PostMapping("/crearGif")
	public String crearGif(@RequestBody Gif gif) {
		gifServicio.crearGif(gif);
		return "redirect:/index";
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