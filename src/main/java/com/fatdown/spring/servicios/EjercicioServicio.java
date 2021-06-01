package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface  EjercicioServicio {

    Ejercicio crearEjercicio(Ejercicio ejercicio);

    void borrarEjercicio(Long id);

    Page<Ejercicio> listarEjerciciosPaginados(Pageable p);

    Optional<Ejercicio> buscarPorId(Long id);

}
