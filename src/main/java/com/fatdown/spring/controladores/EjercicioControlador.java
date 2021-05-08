package com.fatdown.spring.controladores;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.servicios.EjercicioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/ejercicio")
public class EjercicioControlador {

    @Autowired
    EjercicioServicio ejercicioServicio;

    @PostMapping("/crearEjercicio")
    public String crearEjercicio(@Valid @RequestBody Ejercicio ejercicio) {
        ejercicioServicio.crearEjercicio(ejercicio);
        return "redirect:/crearEjercicio";
    }
}
