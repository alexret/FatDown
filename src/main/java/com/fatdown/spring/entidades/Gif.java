package com.fatdown.spring.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Gif extends Multimedia {

	private static final long serialVersionUID = 1029253131656624666L;
	
	@Column(name = "MULTIMEDIA")
	private byte[] multimedia;

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
		super(idMultimedia, nombreMultimedia);
		this.multimedia = multimedia;

	}

	public Gif(String nombreMultimedia, byte[] multimedia) {
		super(nombreMultimedia);
		this.multimedia = multimedia;

	}
	
	public Gif(String nombreMultimedia, byte[] multimedia, Ejercicio ejercicio) {
		super(nombreMultimedia);
		this.multimedia = multimedia;
		this.ejercicio = ejercicio;
	}
	
	public byte[] getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(byte[] multimedia) {
		this.multimedia = multimedia;
	}

}
