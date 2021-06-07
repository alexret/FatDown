package com.fatdown.spring.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.*;

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

	// org.hibernate.AnnotationException: Unknown mappedBy
//	@OneToOne (mappedBy = "consejo", cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private Multimedia multimedia;

	// Constructores

	public Consejo() {
		super();
	}

//	public Consejo(long idConsejo, String nombreConsejo, String descripcionConsejo, Multimedia multimediaConsejo) {
//		super();
//		this.idConsejo = idConsejo;
//		this.nombreConsejo = nombreConsejo;
//		this.descripcionConsejo = descripcionConsejo;
//		this.multimedia = multimediaConsejo;
//	}

	public Consejo(long idConsejo, String nombreConsejo, String descripcionConsejo) {
		super();
		this.idConsejo = idConsejo;
		this.nombreConsejo = nombreConsejo;
		this.descripcionConsejo = descripcionConsejo;
	}

//	public Consejo(String nombreConsejo, String descripcionConsejo, Multimedia multimediaConsejo) {
//		super();
//		this.nombreConsejo = nombreConsejo;
//		this.descripcionConsejo = descripcionConsejo;
//		this.multimedia = multimediaConsejo;
//	}

	public Consejo(String nombreConsejo, String descripcionConsejo) {
		super();
		this.nombreConsejo = nombreConsejo;
		this.descripcionConsejo = descripcionConsejo;
	}

	// Getters & Setters

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

//	public Multimedia getMultimediaConsejo() {
//		return multimedia;
//	}
//
//	public void setMultimediaConsejo(Multimedia multimediaConsejo) {
//		this.multimedia = multimediaConsejo;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
