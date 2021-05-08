package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.repositorios.EjercicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EjercicioServicioImp implements EjercicioServicio {

    @Autowired
    private EjercicioRepositorio ejercicioRepositorio;

    @Override
    public Ejercicio crearEjercicio(Ejercicio ejercicio) {
        return ejercicioRepositorio.save(ejercicio);
    }

    @Override
    public void borrarEjercicio(Long id) {
        ejercicioRepositorio.deleteById(id);
    }

    @Override
    public List<Ejercicio> listarEjercicios() {
        return ejercicioRepositorio.findAll();
    }
}
