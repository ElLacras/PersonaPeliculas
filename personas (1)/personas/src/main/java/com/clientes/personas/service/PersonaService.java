package com.clientes.personas.service;

import com.clientes.personas.dto.PersonaListadoDTO;
import com.clientes.personas.dto.PersonaSimpleDTO;
import com.clientes.personas.model.Pelicula;
import com.clientes.personas.model.Persona;
import com.clientes.personas.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonaService {

    private final PersonaRepository repository;

    public PersonaService(PersonaRepository repository) {
        this.repository = repository;
    }

    public Persona guardarPersona(Persona persona) {
        return repository.save(persona);
    }

    public List<Pelicula> obtenerPeliculas(Integer personaId){

        Optional<Persona> personaOpt = repository.findById(personaId);
        if (personaOpt.isEmpty()){
            return new ArrayList<>();
        }
        Persona persona = personaOpt.get();

        List<Pelicula> peliculas = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();

        for (Integer peliculaId : persona.getPeliculasFavoritas()){

            String url = "http://localhost:8080/peliculas/" + peliculaId;

            Pelicula pelicula = restTemplate.getForObject(url, Pelicula.class);

            peliculas.add(pelicula);
        }
        return peliculas;

    }

    public List<PersonaListadoDTO> listarDTO() {

        List<Persona> personas = repository.findAll();
        List<PersonaListadoDTO> lista = new ArrayList<>();

        for (Persona p : personas) {
            PersonaListadoDTO dto = new PersonaListadoDTO();
            dto.setNombre(p.getNombre());
            dto.setEmail(p.getEmail());

            lista.add(dto);
        }

        return lista;

    }

    public PersonaSimpleDTO obtenerDetalleSimple(Integer id) {

        Optional<Persona> personaOpt = repository.findById(id);

        if (personaOpt.isEmpty()) {
            return null;
        }

        Persona persona = personaOpt.get();

        List<Pelicula> peliculas = obtenerPeliculas(id);

        List<String> titulos = new ArrayList<>();

        for (Pelicula p : peliculas) {
            titulos.add(p.getTitulo());
        }

        PersonaSimpleDTO dto = new PersonaSimpleDTO();

        dto.setNombre(persona.getNombre());
        dto.setEmail(persona.getEmail());
        dto.setPeliculas(titulos);

        return dto;
    }
}