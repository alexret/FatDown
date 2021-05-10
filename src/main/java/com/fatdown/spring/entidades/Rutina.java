package com.fatdown.spring.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fatdown.spring.entidades.Usuario;

import java.io.Serializable;

@Entity
@Table(name = "RUTINA")
public class Rutina implements Serializable {

    private static final long serialVersionUID = -8548755844378572452L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RUTINA")
    private Long idRutina;

    // Datos
    @Column(name = "NOMBRE_RUTINA")
    @NotNull(message = "El nombre de la rutina no puede ser nulo")
    @NotBlank(message = "El nombre de la rutina no puede estar vacío")
    private String nombreRutina;

    @ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_EJERCICIO")
    private Ejercicio ejercicio;
    
    // Getters y setters
    
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}


