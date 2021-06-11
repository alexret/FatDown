package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.entidades.Rutina;
import com.fatdown.spring.entidades.Usuario;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface RutinaServicio {

    Rutina addRutina(String nombre,  HttpSession session) throws Exception;

    void deleteRutina(Rutina rutina);

    List<Rutina> getRutinas(Usuario usuario);
}
