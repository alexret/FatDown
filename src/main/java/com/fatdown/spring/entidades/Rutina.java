package com.fatdown.spring.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RUTINA")
public class Rutina implements Serializable {

    private static final long serialVersionUID = -8548755844378572452L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_RUTINA", unique = true, nullable = false)
    private Long idRutina;

    // Datos
    @Column(name = "NOMBRE_RUTINA")
    @NotNull(message = "El nombre de la rutina no puede ser nulo")
    @NotBlank(message = "El nombre de la rutina no puede estar vacío")
    private String nombreRutina;

    @ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@ManyToMany(mappedBy = "rutina")
    private Set<Ejercicio> ejercicio = new HashSet<>();

    public Rutina() {
		super();
	}

	public Rutina(String nombreRutina, Usuario usuario, Set<Ejercicio> ejercicio) {
		super();
		this.nombreRutina = nombreRutina;
		this.usuario = usuario;
		this.ejercicio = ejercicio;
	}

	public Rutina(Long idRutina, String nombreRutina, Usuario usuario, Set<Ejercicio> ejercicio) {
		super();
		this.idRutina = idRutina;
		this.nombreRutina = nombreRutina;
		this.usuario = usuario;
		this.ejercicio = ejercicio;
	}

	// Getters y setters
    
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getIdRutina() {
		return idRutina;
	}

	public void setIdRutina(Long idRutina) {
		this.idRutina = idRutina;
	}

	public String getNombreRutina() {
		return nombreRutina;
	}

	public void setNombreRutina(String nombreRutina) {
		this.nombreRutina = nombreRutina;
	}

	public Set<Ejercicio>  getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Set<Ejercicio> ejercicio) {
		this.ejercicio = ejercicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Rutina{" +
				"idRutina=" + idRutina +
				", nombreRutina='" + nombreRutina + '\'' +
				", usuario=" + usuario +
				", ejercicio=" + ejercicio +
				'}';
	}
}


