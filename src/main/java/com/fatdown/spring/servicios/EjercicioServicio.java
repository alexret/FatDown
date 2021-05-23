package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface  EjercicioServicio {

    Ejercicio crearEjercicio(Ejercicio ejercicio);

    void borrarEjercicio(Long id);

    Page<Ejercicio> listarEjerciciosPaginados(Pageable p);

}
