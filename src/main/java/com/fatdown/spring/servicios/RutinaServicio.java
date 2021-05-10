package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;

public interface RutinaServicio {

    boolean addEjercicio(Ejercicio ejercicio);

    void deleteEjercicio(Ejercicio ejercicio);
}
