package com.fatdown.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fatdown.spring.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
