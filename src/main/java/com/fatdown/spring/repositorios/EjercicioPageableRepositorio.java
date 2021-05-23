package com.fatdown.spring.repositorios;

import com.fatdown.spring.entidades.Ejercicio;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;

public interface  EjercicioPageableRepositorio extends  PagingAndSortingRepository<Ejercicio, Long> {

    Page<Ejercicio> findAll(Pageable p);

}
