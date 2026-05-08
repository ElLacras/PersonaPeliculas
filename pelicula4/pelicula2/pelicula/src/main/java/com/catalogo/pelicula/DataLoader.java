package com.catalogo.pelicula;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.catalogo.pelicula.model.Pelicula;
import com.catalogo.pelicula.repository.PeliculaRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(PeliculaRepository repository){
    return args -> {

        if(repository.count() == 0 ) {
            repository.save(new Pelicula(null, "Gladiador", "Acción", 2000, "Russel Crowe"));
            repository.save(new Pelicula(null, "El señor de los Anillos", "Fantasía", 2001, "Elijah Wood"));
            repository.save(new Pelicula(null, "Batman: El caballero de la noche", "Acción", 2008, "Christian Bale"));
            repository.save(new Pelicula(null, "Avengers", "Acción", 2012, "Robert Downey Jr"));
            repository.save(new Pelicula(null, "Interstellar", "Ciencia ficción", 2014, "Matthew McConaughey"));
            repository.save(new Pelicula(null, "Parasitos", "Drama", 2019, "Song Kang-ho"));

        }
        };
    }
}
