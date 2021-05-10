package com.fatdown.spring.controladores;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.servicios.RutinaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/rutina")
public class RutinaControlador {

    @Autowired
    RutinaServicio rutinaServicio;

    @PostMapping("/addEjercicio")
    public String addEjercicio(@Valid Ejercicio ejercicio) {
        rutinaServicio.addEjercicio(ejercicio);
        return "redirect:/rutina/addEjercicio";
    }
}
