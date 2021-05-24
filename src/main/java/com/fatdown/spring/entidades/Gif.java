package com.fatdown.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Gif extends Multimedia {

	private static final long serialVersionUID = 1029253131656624666L;

	@OneToOne
	@JoinColumn(name = "idEjercicio")
	private Ejercicio ejercicio;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Gif() {
		super();
	}

	public Gif(long idMultimedia, String nombreMultimedia, byte[] multimedia) {
		super(idMultimedia, nombreMultimedia, multimedia);

	}

	public Gif(String nombreMultimedia, byte[] multimedia) {
		super(nombreMultimedia, multimedia);
	}
	
	public Gif(String nombreMultimedia, byte[] multimedia, Ejercicio ejercicio) {
		super(nombreMultimedia, multimedia);
		this.ejercicio = ejercicio;
	}

}
