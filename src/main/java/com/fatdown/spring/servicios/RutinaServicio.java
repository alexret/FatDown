package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.entidades.Rutina;

public interface RutinaServicio {

    Rutina addRutina(Rutina rutina);

    void deleteRutina(Rutina rutina);
}
