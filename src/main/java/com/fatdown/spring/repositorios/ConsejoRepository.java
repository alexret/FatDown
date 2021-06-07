package com.fatdown.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fatdown.spring.entidades.Consejo;

@Repository
@Component("ConsejoRepository")
public interface ConsejoRepository extends JpaRepository<Consejo, Long> {

}
