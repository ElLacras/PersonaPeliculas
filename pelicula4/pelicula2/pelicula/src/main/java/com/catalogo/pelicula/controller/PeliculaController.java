package com.catalogo.pelicula.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.catalogo.pelicula.model.Pelicula;
import com.catalogo.pelicula.service.PeliculaService;

@RestController
@RequestMapping("/peliculas")

public class PeliculaController {
    @Autowired
    private PeliculaService service;

    @GetMapping
    public List<Pelicula> listar() {
        return service.listar();
    }
    
    @GetMapping("/genero/{genero}")
    public List<Pelicula> buscarPorGenero(@PathVariable String genero) {
        return service.buscarPorGenero(genero);
    }
    
    @GetMapping("/anio/{anio}")
    public List<Pelicula> buscarPorAnio(@PathVariable Integer anio) {
        return service.buscarPorAnio(anio);
    }
    
    @GetMapping("/actor/{actor}")
    public List<Pelicula> buscarPorActor(@PathVariable String actor) {
        return service.buscarPorActor(actor);
    }


    @PostMapping("/agregar")
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula){
        return service.guardarPelicula(pelicula);
    }                   



    @DeleteMapping("/Eliminar/{id}")
    public String eliminar(@PathVariable Integer id){

        Optional<Pelicula> pelicula = service.BuscarPorId(id);

        if (pelicula.isPresent()) {

            service.eliminarPorId(id);

            return "pelicula eliminada";
            
        } else {
            return "pelicula no encontrada con id"+id;
        }
        
    }

    @PutMapping("actualizar/{id}")
    public String actualizar (@PathVariable Integer id,@RequestBody Pelicula  pelicula){
        Optional<Pelicula> existe = service.BuscarPorId(id);

        if (existe.isPresent()) {

            service.actualizarPelicula(id, pelicula);

            
            return "pelicula actulizada";
        }else{
            return "pelicula no encontrada por id "+id;
        }
    }

    @GetMapping("/{id}")
public Pelicula buscarPorId(@PathVariable Integer id){
    return service.BuscarPorId(id).orElse(null);
}
    
    
}
