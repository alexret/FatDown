package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RutinaServicioImp implements RutinaServicio {


    @Override
    public boolean addEjercicio(Ejercicio ejercicio) {
        return false;
    }

    @Override
    public void deleteEjercicio(Ejercicio ejercicio) {

    }
}
