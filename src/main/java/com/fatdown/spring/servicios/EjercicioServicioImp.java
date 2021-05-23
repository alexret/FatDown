package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.repositorios.EjercicioPageableRepositorio;
import com.fatdown.spring.repositorios.EjercicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EjercicioServicioImp implements EjercicioServicio {

    @Autowired
    private EjercicioRepositorio ejercicioRepositorio;

    @Autowired
    private EjercicioPageableRepositorio ejercicioPageableRepositorio;

    @Override
    public Ejercicio crearEjercicio(Ejercicio ejercicio) {

        return ejercicioRepositorio.save(ejercicio);
    }

    @Override
    public void borrarEjercicio(Long id) {

        ejercicioRepositorio.deleteById(id);
    }

    @Override
    public Page<Ejercicio> listarEjerciciosPaginados(Pageable p) {

        return ejercicioPageableRepositorio.findAll(p);
    }


}
