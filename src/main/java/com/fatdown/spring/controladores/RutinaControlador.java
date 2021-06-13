package com.fatdown.spring.controladores;

import com.fasterxml.jackson.databind.JsonNode;
import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.entidades.Rutina;
import com.fatdown.spring.entidades.Usuario;
import com.fatdown.spring.enums.Categoria;
import com.fatdown.spring.repositorios.UsuarioRepository;
import com.fatdown.spring.servicios.EjercicioServicio;
import com.fatdown.spring.servicios.RutinaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;


@Controller
@RequestMapping(value = "/rutina")
public class RutinaControlador {

    @Autowired
    RutinaServicio rutinaServicio;

    @Autowired
    EjercicioServicio ejercicioServicio;

    @GetMapping("/listarEjercicios")
    public ModelAndView listarEjercicios() {
        ModelAndView mav = new ModelAndView();
        Pageable paging = PageRequest.of(0,10);
        Page<Ejercicio> lEjercicios = ejercicioServicio.listarEjerciciosPaginados(paging);

        mav.addObject("ejercicio", lEjercicios);
        mav.setViewName("ejercicio/listarEjercicios");
        return mav;
    }

    @PostMapping("/filtrarEjercicio")
    public ModelAndView listarEjercicioPorCategoria(@RequestParam(name = "categoriaEjercicio") Categoria nombre) {
        ModelAndView mav = new ModelAndView();
        List<Ejercicio> lEjercicios = ejercicioServicio.buscarPorCategoriaEjercicio(nombre);

        mav.addObject("ejercicio", lEjercicios);
        mav.setViewName("ejercicio/listarEjercicios");
        return mav;
    }

    @PostMapping("/addEjercicio/{id}")
    public String addEjercicio(@PathVariable("id") long id, HttpSession session) throws Exception {

        Ejercicio ejercicio;
        Optional<Ejercicio> aux = ejercicioServicio.buscarPorId(id);

        if(aux.isPresent()) {

            ejercicio = aux.get();

            // Valor por defecto es 5
            Set<Ejercicio> lEjercicio = (Set<Ejercicio>) session.getAttribute("tuRutina");

            lEjercicio.add(ejercicio);

            session.setAttribute("tuRutina", lEjercicio);

            return "redirect:/rutina/listarEjercicios";
        }
        else
            throw new Exception("Ha ocurrido un error");
    }

    @PostMapping("/crearRutina")
    public String crearRutina(@RequestParam(value = "nombre", required = false) String nombre,
                              HttpSession session) throws Exception {
        
        rutinaServicio.addRutina(nombre, session);
        return "redirect:/index";
    }


    @PostMapping(value = "/borrarRutina", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean  borrarRutina(@RequestBody JsonNode values) {
        JsonNode aux = values.findValue("idRutina");
        Optional<Rutina> auxRutina = rutinaServicio.buscarRutina(aux.asLong()   );
        if(auxRutina.isPresent())
            rutinaServicio.deleteRutina(auxRutina.get());

        return true;
    }

}
