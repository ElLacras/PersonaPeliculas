package com.clientes.personas.model;

import lombok.Data;

@Data
public class Pelicula {

    private Integer id;

    private String titulo;

    private String genero;

    private Integer anio;

    private String actorPrincipal;

}
