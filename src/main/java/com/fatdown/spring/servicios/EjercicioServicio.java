package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;

import java.util.List;

public interface  EjercicioServicio {

    public Ejercicio crearEjercicio(Ejercicio ejercicio);

    public void borrarEjercicio(Long id);

    public List<Ejercicio> listarEjercicios();
}
