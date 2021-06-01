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
import java.util.Optional;


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
    @ResponseBody
    public String addEjercicio(@PathVariable("id") long id,
                               @RequestParam(value = "nombre", required = false) String nombre,
                               HttpSession session) {

        Rutina rutina = new Rutina();
        Optional<Usuario> usuario = usuarioRepository.findById((Long) session.getAttribute("idUsuario"));
        Ejercicio ejercicio = ejercicioServicio.buscarPorId(id).get();
        rutina.setNombreRutina(nombre);
        rutina.setEjercicio(ejercicio);
        rutina.setUsuario(usuario.get());
        rutinaServicio.addRutina(rutina);
        return "redirect:/rutina/listarEjercicios";
    }

    @PostMapping("/deleteEjercicio")
    public String deleteEjercicio(@Valid Rutina rutina) {
        rutinaServicio.deleteRutina(rutina);
        return "redirect:/rutina/addEjercicio";
    }
}
