package com.fatdown.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

//An entity cannot be annotated with both @Entity and @MappedSuperclass
//@MappedSuperclass
@Entity
public class Gif extends Multimedia {

	private static final long serialVersionUID = 1029253131656624666L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
