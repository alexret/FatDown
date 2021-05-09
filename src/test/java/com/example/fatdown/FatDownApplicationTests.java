package com.example.fatdown;

import com.fatdown.spring.controladores.EjercicioControlador;
import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.repositorios.EjercicioRepositorio;
import com.fatdown.spring.servicios.EjercicioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fatdown.spring.FatDownApplication;

@SpringBootTest(classes = FatDownApplication.class)
class FatDownApplicationTests {

	@Autowired
	EjercicioControlador ejercicioControlador;

	@Autowired
	EjercicioRepositorio ejercicioRepositorio;

	@Test
	void contextLoads() {

		Ejercicio e = new Ejercicio();
		e.setIdEjercicio(1l);
		e.setNombreEjercicio("Prueba1");
		e.setCategoriaEjercicio("Prueba1");
		e.setCategoriaEjercicio("Pruebaaa1");
		Ejercicio f = new Ejercicio();
		f.setIdEjercicio(2l);
		f.setNombreEjercicio("Prueba2");
		f.setCategoriaEjercicio("Prueba2");
		f.setCategoriaEjercicio("Pruebaaa2");
		Ejercicio g = new Ejercicio();
		g.setIdEjercicio(3l);
		g.setNombreEjercicio("Prueba3");
		g.setCategoriaEjercicio("Prueba4");
		g.setCategoriaEjercicio("Pruebaaa4");
		ejercicioControlador.crearEjercicio(e);
		ejercicioControlador.crearEjercicio(f);
		ejercicioControlador.crearEjercicio(g);

		System.out.println(ejercicioRepositorio.findAll());
	}

}
