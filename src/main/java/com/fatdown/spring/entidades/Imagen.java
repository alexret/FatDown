package com.fatdown.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Entity
public class Imagen extends Multimedia {

	private static final long serialVersionUID = -3345527462207587040L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
