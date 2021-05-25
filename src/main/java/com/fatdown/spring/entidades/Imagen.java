package com.fatdown.spring.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//An entity cannot be annotated with both @Entity and @MappedSuperclass
//@MappedSuperclass
@Entity
public class Imagen extends Multimedia {

	private static final long serialVersionUID = -3345527462207587040L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "MULTIMEDIA")
	private byte[] multimedia;

	@OneToOne
	@JoinColumn(name = "id_consejo")
	private Consejo consejo;

	public Imagen() {
		super();

	}

	public Imagen(long idMultimedia, String nombreMultimedia, byte[] multimedia) {
		super(idMultimedia, nombreMultimedia);
		this.multimedia = multimedia;

	}

	public Imagen(String nombreMultimedia, byte[] multimedia) {
		super(nombreMultimedia);
		this.multimedia = multimedia;

	}

	public byte[] getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(byte[] multimedia) {
		this.multimedia = multimedia;
	}
}
