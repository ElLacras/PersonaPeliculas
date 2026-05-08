package com.catalogo.pelicula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalogo.pelicula.model.Pelicula;
import com.catalogo.pelicula.repository.PeliculaRepository;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository repository;

    public List<Pelicula> listar() {
        return repository.findAll();
    }
    
    public Optional<Pelicula> buscarPorTitulo(String titulo){
        return repository.findByTituloIgnoreCase(titulo);
    }
    
    public List<Pelicula> buscarPorGenero(String genero){
        return repository.findByGeneroIgnoreCase(genero);
    }
    
    public List<Pelicula> buscarPorAnio(Integer anio){
        return repository.findByAnio(anio);
    }
    
    public List<Pelicula> buscarPorActor(String actor){
        return repository.findByActorPrincipalIgnoreCase(actor);
    }


    public Pelicula guardarPelicula(Pelicula pelicula){
        return repository.save(pelicula);
    }
    
    public void eliminarPorId(Integer id){
        repository.deleteById(id);
    }


    public Optional<Pelicula> BuscarPorId(Integer id){
        return repository.findById(id);
        
    }

    public Pelicula actualizarPelicula(Integer id,Pelicula pelicula){
        pelicula.setId(id);
        return repository.save(pelicula);
    }
}
