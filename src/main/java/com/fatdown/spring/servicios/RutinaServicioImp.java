package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.entidades.Rutina;
import com.fatdown.spring.repositorios.RutinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RutinaServicioImp implements RutinaServicio {


    @Autowired
    RutinaRepositorio rutinaRepositorio;

    @Override
    public Rutina addRutina(Rutina rutina) {
        return rutinaRepositorio.save(rutina);
    }

    @Override
    public void deleteRutina(Rutina rutina) {
        rutinaRepositorio.delete(rutina);
    }
}
