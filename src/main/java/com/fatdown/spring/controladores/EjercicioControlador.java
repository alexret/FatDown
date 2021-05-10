package com.fatdown.spring.controladores;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.servicios.EjercicioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/ejercicio")
public class EjercicioControlador {

    @Autowired
    EjercicioServicio ejercicioServicio;

    @GetMapping("/crearEjercicio")
    public String creaEjericio(Model model, HttpSession session) {

        return "ejercicio/crearEjercicio";
    }

    @PostMapping("/crearEjercicio")
    public String crearEjercicio(@Valid Ejercicio ejercicio) {
        ejercicioServicio.crearEjercicio(ejercicio);
        return "redirect:/ejercicio/crearEjercicio";
    }
/*
    @PostMapping("/eliminarEjercicio")
    public String eliminarEjercicio(@Valid Ejercicio ejercicio) {
        ejercicioServicio.borrarEjercicio(ejercicio.getIdEjercicio());
        return "redirect:/index";
    }
*/
    @PostMapping("/listarEjercicios")
    public String listarEjercicios() {
        ejercicioServicio.listarEjercicios();
        return "redirect:/index";
    }
}
