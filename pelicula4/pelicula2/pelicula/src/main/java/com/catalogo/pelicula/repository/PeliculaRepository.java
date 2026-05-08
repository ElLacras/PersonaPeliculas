package com.catalogo.pelicula.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.catalogo.pelicula.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

    Optional<Pelicula> findByTituloIgnoreCase(String titulo);
    
    List<Pelicula> findByGeneroIgnoreCase(String genero);
    
    List<Pelicula> findByAnio(Integer anio);
    
    List<Pelicula> findByActorPrincipalIgnoreCase(String actorPrincipal);

    

}
