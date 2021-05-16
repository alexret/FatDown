package com.fatdown.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

//An entity cannot be annotated with both @Entity and @MappedSuperclass
//@MappedSuperclass
@Entity
public class Gif extends Multimedia {

	private static final long serialVersionUID = 1029253131656624666L;

	@OneToOne
	@JoinColumn(name = "FK_EJERCICIO", updatable = false, nullable = false)
	private Ejercicio ejercicio;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
