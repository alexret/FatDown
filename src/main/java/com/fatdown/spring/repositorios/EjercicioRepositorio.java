package com.fatdown.spring.repositorios;

import com.fatdown.spring.entidades.Ejercicio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  EjercicioRepositorio extends CrudRepository<Ejercicio, Long> {

    List<Ejercicio> findAll();
}
