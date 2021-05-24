package com.fatdown.spring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fatdown.spring.entidades.Imagen;

@Repository
@Component("imagenRepository")
public interface ImagenRepository extends CrudRepository<Imagen, Long> {

}
