package com.fatdown.spring.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONSEJO")

public class Consejo implements Serializable {

	private static final long serialVersionUID = 135391891082681815L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONSEJO")
	private long idConsejo;

	@Column(name = "NOMBRE_CONSEJO")
	private String nombreConsejo;

	@Column(name = "DESCRIPCION_CONSEJO")
	private String descripcionConsejo;

	@Column(name = "MULTIMEDIA_CONSEJO")
	private Multimedia multimediaConsejo;
	
	//Constructores

	public Consejo() {
		super();
	}

	public Consejo(long idConsejo, String nombreConsejo, String descripcionConsejo, Multimedia multimediaConsejo) {
		super();
		this.idConsejo = idConsejo;
		this.nombreConsejo = nombreConsejo;
		this.descripcionConsejo = descripcionConsejo;
		this.multimediaConsejo = multimediaConsejo;
	}

	public Consejo(String nombreConsejo, String descripcionConsejo, Multimedia multimediaConsejo) {
		super();
		this.nombreConsejo = nombreConsejo;
		this.descripcionConsejo = descripcionConsejo;
		this.multimediaConsejo = multimediaConsejo;
	}
	
	//Getters & Setters

	public long getIdConsejo() {
		return idConsejo;
	}

	public void setIdConsejo(long idConsejo) {
		this.idConsejo = idConsejo;
	}

	public String getNombreConsejo() {
		return nombreConsejo;
	}

	public void setNombreConsejo(String nombreConsejo) {
		this.nombreConsejo = nombreConsejo;
	}

	public String getDescripcionConsejo() {
		return descripcionConsejo;
	}

	public void setDescripcionConsejo(String descripcionConsejo) {
		this.descripcionConsejo = descripcionConsejo;
	}

	public Multimedia getMultimediaConsejo() {
		return multimediaConsejo;
	}

	public void setMultimediaConsejo(Multimedia multimediaConsejo) {
		this.multimediaConsejo = multimediaConsejo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
