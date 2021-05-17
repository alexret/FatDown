package com.fatdown.spring.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
//Designates a class whose mapping information is applied to the entities that inherit from it. A mapped superclass has no separate table defined for it.
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Multimedia implements Serializable {

	private static final long serialVersionUID = 3927283300115653324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MULTIMEDIA")
	private long idMultimedia;

	@Column(name = "NOMBRE_MULTIMEDIA")
	private String nombreMultimedia;

	@Column(name = "MULTIMEDIA")
	private byte multimedia;

	@OneToOne
	@JoinColumn(name = "id_consejo")
	private Consejo consejo;

	@OneToOne
	@JoinColumn(name = "id_ejercicio")
	private Ejercicio ejercicio;

	// Constructores

	public Multimedia() {
		super();
	}

	public Multimedia(byte multimedia) {
		super();
		this.multimedia = multimedia;
	}

	public Multimedia(String nombreMultimedia, byte multimedia, Consejo consejo, Ejercicio ejercicio) {
		super();
		this.nombreMultimedia = nombreMultimedia;
		this.multimedia = multimedia;
		this.consejo = consejo;
		this.ejercicio = ejercicio;
	}

	public Multimedia(long idMultimedia, String nombreMultimedia, byte multimedia, Consejo consejo,
			Ejercicio ejercicio) {
		super();
		this.idMultimedia = idMultimedia;
		this.nombreMultimedia = nombreMultimedia;
		this.multimedia = multimedia;
		this.consejo = consejo;
		this.ejercicio = ejercicio;
	}

	// Getters & Setters

	public long getIdMultimedia() {
		return idMultimedia;
	}

	public void setIdMultimedia(long idMultimedia) {
		this.idMultimedia = idMultimedia;
	}

	public String getNombreMultimedia() {
		return nombreMultimedia;
	}

	public void setNombreMultimedia(String nombreMultimedia) {
		this.nombreMultimedia = nombreMultimedia;
	}

	public byte getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(byte multimedia) {
		this.multimedia = multimedia;
	}

	public Consejo getConsejo() {
		return consejo;
	}

	public void setConsejo(Consejo consejo) {
		this.consejo = consejo;
	}

	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Methods

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consejo == null) ? 0 : consejo.hashCode());
		result = prime * result + ((ejercicio == null) ? 0 : ejercicio.hashCode());
		result = prime * result + (int) (idMultimedia ^ (idMultimedia >>> 32));
		result = prime * result + multimedia;
		result = prime * result + ((nombreMultimedia == null) ? 0 : nombreMultimedia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multimedia other = (Multimedia) obj;
		if (consejo == null) {
			if (other.consejo != null)
				return false;
		} else if (!consejo.equals(other.consejo))
			return false;
		if (ejercicio == null) {
			if (other.ejercicio != null)
				return false;
		} else if (!ejercicio.equals(other.ejercicio))
			return false;
		if (idMultimedia != other.idMultimedia)
			return false;
		if (multimedia != other.multimedia)
			return false;
		if (nombreMultimedia == null) {
			if (other.nombreMultimedia != null)
				return false;
		} else if (!nombreMultimedia.equals(other.nombreMultimedia))
			return false;
		return true;
	}

}
