package com.fatdown.spring.DTO;

import com.fatdown.spring.entidades.Gif;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EjercicioDTO {
    // Datos
    @NotNull(message = "El nombre del ejercicio no puede ser nulo")
    @NotBlank(message = "El nombre del ejercicio no puede estar vacío")
    private String nombreEjercicio;

    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
    @NotBlank(message = "La descripcion no puede estar vacío")
    private String descripcionEjercicio;

    @NotNull(message = "La categoria del ejercicio no puede ser nulo")
    @NotBlank(message = "La categoría no puede estar vacío")
    private String categoriaEjercicio;

    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
    @NotBlank(message = "La descripcion no puede estar vací0")
    private String tipoEjercicio;

    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
    @NotBlank(message = "La descripcion no puede estar vací0")
    private String repeticionEjercicio;

    @NotNull(message = "La descripcion del ejercicio no puede ser nulo")
    @NotBlank(message = "La descripcion no puede estar vací0")
    private int duracionEjercicio;

    private Gif gif;
}
