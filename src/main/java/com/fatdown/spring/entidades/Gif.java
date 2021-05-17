package com.fatdown.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Entity
public class Gif extends Multimedia {

	private static final long serialVersionUID = 1029253131656624666L;

	// No esta claro si esto va aqui o en Multimedia
	@OneToOne
	@JoinColumn(name = "FK_EJERCICIO", updatable = false, nullable = false)
	private Ejercicio ejercicio;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Gif() {
		super();
	}

	public Gif(Ejercicio ejercicio) {
		super();
		this.ejercicio = ejercicio;
	}

}
