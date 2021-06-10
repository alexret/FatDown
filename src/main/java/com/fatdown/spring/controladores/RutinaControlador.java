package com.fatdown.spring.controladores;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.entidades.Rutina;
import com.fatdown.spring.entidades.Usuario;
import com.fatdown.spring.repositorios.UsuarioRepository;
import com.fatdown.spring.servicios.EjercicioServicio;
import com.fatdown.spring.servicios.RutinaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/listarEjercicios")
    public ModelAndView listarEjercicios() {
        ModelAndView mav = new ModelAndView();
        Pageable paging = PageRequest.of(0,10);
        Page<Ejercicio> lEjercicios = ejercicioServicio.listarEjerciciosPaginados(paging);

        mav.addObject("ejercicio", lEjercicios);
        mav.setViewName("rutina/crearRutina");
        return mav;
    }

    @PostMapping("/addEjercicio/{id}")
    public String addEjercicio(@PathVariable("id") long id, HttpSession session) {

        Ejercicio ejercicio = ejercicioServicio.buscarPorId(id).get();

        // Valor por defecto es 5
        Set<Ejercicio> lEjercicio = (Set<Ejercicio>) session.getAttribute("tuRutina");

        lEjercicio.add(ejercicio);

        session.setAttribute("tuRutina", lEjercicio);

        return "redirect:/rutina/listarEjercicios";
    }

    @PostMapping("/crearRutina")
    public String crearRutina(@RequestParam(value = "nombre", required = false) String nombre,
                              HttpSession session){
        Rutina rutina = new Rutina();
        Optional<Usuario> usuario = usuarioRepository.findById((Long) session.getAttribute("idUsuario"));
        Set<Ejercicio> lEjercicio = (Set<Ejercicio>) session.getAttribute("tuRutina");
        Set<Ejercicio> ejercicioAux = new HashSet<Ejercicio>();


        rutina.setNombreRutina(nombre);
        rutina.setUsuario(usuario.get());

        for (Ejercicio e : lEjercicio) {
            Optional<Ejercicio> ejercicio = ejercicioServicio.buscarPorId(e.getIdEjercicio());
//            rutina.setEjercicio(lEjercicio.get(i));
            ejercicioAux.add(ejercicio.get());
        }
//
        rutina.setEjercicio(ejercicioAux);
        
        rutinaServicio.addRutina(rutina);
        return "redirect:/index";
    }


    @PostMapping("/deleteEjercicio")
    public String deleteEjercicio(@Valid Rutina rutina) {
        rutinaServicio.deleteRutina(rutina);
        return "redirect:/rutina/addEjercicio";
    }

    @GetMapping("/getRutina")
    public ModelAndView getRutina(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Optional<Usuario> usuario = usuarioRepository.findById((Long) session.getAttribute("idUsuario"));
        List<Rutina> lRutina = rutinaServicio.getRutinas(usuario.get());

        mav.addObject("rutina", lRutina);
        mav.setViewName("rutina/listarRutinas");
        return mav;
    }
}
