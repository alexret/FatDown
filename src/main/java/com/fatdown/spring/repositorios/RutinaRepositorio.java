package com.fatdown.spring.repositorios;

import com.fatdown.spring.entidades.Rutina;
import com.fatdown.spring.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RutinaRepositorio extends CrudRepository<Rutina, Long> {

    List<Rutina> findByUsuario(Usuario usuario);
}
