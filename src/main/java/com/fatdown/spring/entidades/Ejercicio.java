package com.fatdown.spring.entidades;

//import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

/* @ de lombok para que se autogenere el constructor y los getter y setter*/
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "EJERCICIO")
public class Ejercicio implements Serializable {

    private static final long serialVersionUID = -8548755844378572454L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EJERCICIO")
    private Long idEjercicio;

    // Datos
    @Column(name = "NOMBRE_EJERCICIO")
//    @NotNull(message = "El nombre del ejercicio no puede ser nulo")
//    @NotBlank(message = "El nombre del ejercicio no puede estar vacío")
    private String nombreEjercicio;

    @Column(name = "DESCRIPCION_EJERCICIO")
//    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
//    @NotBlank(message = "La descripcion no puede estar vacío")
    private String descripcionEjercicio;

    @Column(name = "CATEGORIA_EJERCICIO")
//    @NotNull(message = "La categoria del ejercicio no puede ser nulo")
//    @NotBlank(message = "La categoría no puede estar vacío")
    private String categoriaEjercicio;

    @Column(name = "MULTIMEDIA_EJERCICIO")
//    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
//    @NotBlank(message = "La descripcion no puede estar vací0")
    private String multimediaEjercicio;

    @Column(name = "TIPO_EJERCICIO")
//    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
//    @NotBlank(message = "La descripcion no puede estar vací0")
    private String tipoEjercicio;

    @Column(name = "REPETICION_EJERCICIO")
//    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
//    @NotBlank(message = "La descripcion no puede estar vací0")
    private String repeticionEjercicio;

    @Column(name = "DURACION_EJERCICIO")
//    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
//    @NotBlank(message = "La descripcion no puede estar vací0")
    private String duracionEjercicio;

    // Relación OneToMany LineasProducto
    @OneToMany(mappedBy="ejercicio",
            cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            orphanRemoval=true)
    private Set<Rutina> rutina = new HashSet<>();
    

	public Ejercicio() {
		super();
	}
	

	public Ejercicio(String nombreEjercicio, String descripcionEjercicio, String categoriaEjercicio,
			String multimediaEjercicio, String tipoEjercicio, String repeticionEjercicio, String duracionEjercicio,
			Set<Rutina> rutina) {
		super();
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.categoriaEjercicio = categoriaEjercicio;
		this.multimediaEjercicio = multimediaEjercicio;
		this.tipoEjercicio = tipoEjercicio;
		this.repeticionEjercicio = repeticionEjercicio;
		this.duracionEjercicio = duracionEjercicio;
		this.rutina = rutina;
	}



	public Ejercicio(Long idEjercicio, String nombreEjercicio, String descripcionEjercicio, String categoriaEjercicio,
			String multimediaEjercicio, String tipoEjercicio, String repeticionEjercicio, String duracionEjercicio,
			Set<Rutina> rutina) {
		super();
		this.idEjercicio = idEjercicio;
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.categoriaEjercicio = categoriaEjercicio;
		this.multimediaEjercicio = multimediaEjercicio;
		this.tipoEjercicio = tipoEjercicio;
		this.repeticionEjercicio = repeticionEjercicio;
		this.duracionEjercicio = duracionEjercicio;
		this.rutina = rutina;
	}



	public Long getIdEjercicio() {
		return idEjercicio;
	}

	public void setIdEjercicio(Long idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public String getNombreEjercicio() {
		return nombreEjercicio;
	}

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

	public String getDescripcionEjercicio() {
		return descripcionEjercicio;
	}

	public void setDescripcionEjercicio(String descripcionEjercicio) {
		this.descripcionEjercicio = descripcionEjercicio;
	}

	public String getCategoriaEjercicio() {
		return categoriaEjercicio;
	}

	public void setCategoriaEjercicio(String categoriaEjercicio) {
		this.categoriaEjercicio = categoriaEjercicio;
	}

	public String getMultimediaEjercicio() {
		return multimediaEjercicio;
	}

	public void setMultimediaEjercicio(String multimediaEjercicio) {
		this.multimediaEjercicio = multimediaEjercicio;
	}

	public String getTipoEjercicio() {
		return tipoEjercicio;
	}

	public void setTipoEjercicio(String tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

	public String getRepeticionEjercicio() {
		return repeticionEjercicio;
	}

	public void setRepeticionEjercicio(String repeticionEjercicio) {
		this.repeticionEjercicio = repeticionEjercicio;
	}

	public String getDuracionEjercicio() {
		return duracionEjercicio;
	}

	public void setDuracionEjercicio(String duracionEjercicio) {
		this.duracionEjercicio = duracionEjercicio;
	}

	public Set<Rutina> getRutina() {
		return rutina;
	}

	public void setRutina(Set<Rutina> rutina) {
		this.rutina = rutina;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    


}
