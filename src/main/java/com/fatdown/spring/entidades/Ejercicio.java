package com.fatdown.spring.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/* @ de lombok para que se autogenere el constructor y los getter y setter*/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EJERCICIO")
public class Ejercicio implements Serializable {

    private static final long serialVersionUID = -8548755844378572454L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idEjercicio;

    // Datos
    @Column(name = "NOMBRE_EJERCICIO")
    @NotNull(message = "El nombre del ejercicio no puede ser nulo")
    @NotBlank(message = "El nombre del ejercicio no puede estar vacío")
    private String nombreEjercicio;

    @Column(name = "DESCRIPCION_EJERCICIO")
    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
    @NotBlank(message = "La descripcion no puede estar vacío")
    private String descripcionEjercicio;

    @Column(name = "CATEGORIA_EJERCICIO")
    @NotNull(message = "La categoria del ejercicio no puede ser nulo")
    @NotBlank(message = "La categoría no puede estar vacío")
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



}
