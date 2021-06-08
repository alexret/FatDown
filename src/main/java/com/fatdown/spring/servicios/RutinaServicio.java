package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.entidades.Rutina;
import com.fatdown.spring.entidades.Usuario;

import java.util.List;

public interface RutinaServicio {

    Rutina addRutina(Rutina rutina);

    void deleteRutina(Rutina rutina);

    List<Rutina> getRutinas(Usuario usuario);
}
