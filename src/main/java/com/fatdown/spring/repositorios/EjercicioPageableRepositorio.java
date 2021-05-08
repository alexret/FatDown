package com.fatdown.spring.repositorios;

import com.fatdown.spring.entidades.Ejercicio;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  EjercicioPageableRepositorio extends  PagingAndSortingRepository<Ejercicio, Long> {

}
