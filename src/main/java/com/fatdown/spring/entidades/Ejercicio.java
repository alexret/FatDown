package com.fatdown.spring.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fatdown.spring.enums.Categoria;

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
    @NotNull(message = "El nombre del ejercicio no puede ser nulo")
    @NotBlank(message = "El nombre del ejercicio no puede estar vacío")
    private String nombreEjercicio;

    @Column(name = "DESCRIPCION_EJERCICIO")
    @NotNull(message = "La descripción del ejercicio no puede ser nulo")
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcionEjercicio;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA_EJERCICIO")
    @NotNull(message = "La categoría del ejercicio no puede ser nula")
    @NotBlank(message = "La categoría no puede estar vacía")
    private Categoria categoriaEjercicio;

    @Column(name = "TIPO_EJERCICIO")
    @NotNull(message = "El tipo de ejercicio no puede ser nulo")
    @NotBlank(message = "El tipo de ejercicio no puede estar vacío")
    private String tipoEjercicio;

    @Column(name = "REPETICION_EJERCICIO")
    private int repeticionEjercicio;

    @Column(name = "DURACION_EJERCICIO")
    private int duracionEjercicio;

    // Relación OneToMany
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(
			name = "rutina_ejercicio",
			joinColumns = @JoinColumn(name = "idEjercicio"),
			inverseJoinColumns = @JoinColumn(name = "idRutina"))
    private Set<Rutina> rutina = new HashSet<>();

	@OneToOne(mappedBy = "ejercicio", cascade = CascadeType.ALL)
	private Gif gif;
	
	public Ejercicio() {
		super();
	}

	// Constructor con todos los campos pero sin ID
	public Ejercicio(String nombreEjercicio, String descripcionEjercicio, Categoria categoriaEjercicio,
			String tipoEjercicio, int repeticionEjercicio, int duracionEjercicio, Set<Rutina> rutina) {
		super();
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.categoriaEjercicio = categoriaEjercicio;
		this.tipoEjercicio = tipoEjercicio;
		this.repeticionEjercicio = repeticionEjercicio;
		this.duracionEjercicio = duracionEjercicio;
		this.rutina = rutina;
	}

	public Ejercicio(String nombreEjercicio, String descripcionEjercicio, Categoria categoriaEjercicio,
			String tipoEjercicio, int repeticionEjercicio, int duracionEjercicio) {
		super();
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.categoriaEjercicio = categoriaEjercicio;
		this.tipoEjercicio = tipoEjercicio;
		this.repeticionEjercicio = repeticionEjercicio;
		this.duracionEjercicio = duracionEjercicio;
	}

	// Constructor con todos los campos menos duracionEjercicio
	public Ejercicio(String nombreEjercicio, String descripcionEjercicio, Categoria categoriaEjercicio,
			String tipoEjercicio, int repeticionEjercicio, Set<Rutina> rutina, Gif gif) {
		super();
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.categoriaEjercicio = categoriaEjercicio;
		this.tipoEjercicio = tipoEjercicio;
		this.repeticionEjercicio = repeticionEjercicio;
		this.rutina = rutina;
		this.gif = gif;
	}

	public Ejercicio(String nombreEjercicio, String descripcionEjercicio, Categoria categoriaEjercicio,
			String tipoEjercicio, int repeticionEjercicio, Gif gif) {
		super();
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.categoriaEjercicio = categoriaEjercicio;
		this.tipoEjercicio = tipoEjercicio;
		this.repeticionEjercicio = repeticionEjercicio;
		this.gif = gif;
	}

	// Constructor con todos los campos menos repeticionEjercicio
	public Ejercicio(Long idEjercicio, String nombreEjercicio, String descripcionEjercicio,
			Categoria categoriaEjercicio, String tipoEjercicio, int duracionEjercicio, Set<Rutina> rutina, Gif gif) {
		super();
		this.idEjercicio = idEjercicio;
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.categoriaEjercicio = categoriaEjercicio;
		this.tipoEjercicio = tipoEjercicio;
		this.duracionEjercicio = duracionEjercicio;
		this.rutina = rutina;
		this.gif = gif;
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

	public Categoria getCategoriaEjercicio() {
		return categoriaEjercicio;
	}

	public void setCategoriaEjercicio(Categoria categoriaEjercicio) {
		this.categoriaEjercicio = categoriaEjercicio;
	}

	public String getTipoEjercicio() {
		return tipoEjercicio;
	}

	public void setTipoEjercicio(String tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

	public int getRepeticionEjercicio() {
		return repeticionEjercicio;
	}

	public void setRepeticionEjercicio(int repeticionEjercicio) {
		this.repeticionEjercicio = repeticionEjercicio;
	}

	public int getDuracionEjercicio() {
		return duracionEjercicio;
	}

	public void setDuracionEjercicio(int duracionEjercicio) {
		this.duracionEjercicio = duracionEjercicio;
	}

	public Set<Rutina> getRutina() {
		return rutina;
	}

	public void setRutina(Set<Rutina> rutina) {
		this.rutina = rutina;
	}
	
	public void anadirRutina(Rutina rutina) {
		this.rutina.add(rutina);
		rutina.getEjercicio().add(this);
	}
	
	public void deleteRutina(Rutina rutina) {
		this.rutina.remove(rutina) ;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Gif getGif() {
		return gif;
	}

	public void setGif(Gif gif) {
		this.gif = gif;
	}

}
