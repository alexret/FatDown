package com.fatdown.spring.controladores;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.entidades.Gif;
import com.fatdown.spring.servicios.EjercicioServicio;
import com.fatdown.spring.servicios.GifServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "/ejercicio")
public class EjercicioControlador {

    @Autowired
    EjercicioServicio ejercicioServicio;

    @Autowired
    GifServicio gifServicio;

    @GetMapping("/crearEjercicio")
    public String creaEjericio(Model model, HttpSession session) {

        return "ejercicio/crearEjercicio";
    }

    @PostMapping("/crearEjercicio")
    //public String crearEjercicio(@Valid Ejercicio ejercicio) {
    public String crearEjercicio(Ejercicio ejercicio, @RequestParam("subirGif") MultipartFile file) throws IOException {

    	// Necesitamos ver cómo se recupera la cateoría del ejercicio
    	// Y si al deshabilitar una de las dos opciones (duracion/repeticion)
    	// la que no recoge la pone a null sin problemas
        ejercicio = ejercicioServicio.crearEjercicio(ejercicio);
        byte[] image = file.getBytes();
        Gif gif = new Gif(ejercicio.getNombreEjercicio(), image, ejercicio);
        gifServicio.crearGif(gif);
        return "redirect:/ejercicio/crearEjercicio";
    }


    @PostMapping("/eliminarEjercicio/{id}")
    public String eliminarEjercicio(@PathVariable("id") long id) {
        ejercicioServicio.borrarEjercicio(id);
        return "redirect:/ejercicio/listarEjercicios";
    }


    @GetMapping("/listarEjercicios")
    public ModelAndView listarEjercicios() {
        ModelAndView mav = new ModelAndView();
        Pageable paging = PageRequest.of(0,10);
        Page<Ejercicio> lEjercicios = ejercicioServicio.listarEjerciciosPaginados(paging);

        mav.addObject("ejercicio", lEjercicios);
        mav.setViewName("ejercicio/listarEjercicios");
        return mav;
    }
}
