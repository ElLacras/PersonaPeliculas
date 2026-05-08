package com.clientes.personas.controller;

import com.clientes.personas.dto.PersonaListadoDTO;
import com.clientes.personas.dto.PersonaSimpleDTO;
import com.clientes.personas.model.Pelicula;
import com.clientes.personas.model.Persona;
import com.clientes.personas.service.PersonaService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Persona> crearPersona(@Valid @RequestBody Persona persona) {

        Persona nueva = service.guardarPersona(persona);

        return ResponseEntity.status(201).body(nueva);
    }

    @GetMapping("{id}/peliculas")
    public List<Pelicula> obtenerPeliculas(@PathVariable Integer id){
        return service.obtenerPeliculas(id);
    }

    @GetMapping("/listar-dto")
    public List<PersonaListadoDTO> listarDTO() {
        return service.listarDTO();
    }

    @GetMapping("/{id}/detalle-simple")
    public PersonaSimpleDTO obtenerDetalleSimple(@PathVariable Integer id) {
        return service.obtenerDetalleSimple(id);
    }

    
}