package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;

import java.util.List;

public interface  EjercicioServicio {

    Ejercicio crearEjercicio(Ejercicio ejercicio);

    void borrarEjercicio(Long id);

    List<Ejercicio> listarEjercicios();

}
