package com.catalogo.pelicula.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pelicula")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El titulo no puede estar vacio")
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank(message = "El genero no puede estar vacio")
    private String genero;

    @Min(value = 1999, message = "El año debe ser mayor a 1900")
    @NotNull(message =  "El año no puede ser nulo")
    private Integer anio;

    @NotBlank(message = "El actor principal no puede estar vacio")
    private String actorPrincipal;
}
