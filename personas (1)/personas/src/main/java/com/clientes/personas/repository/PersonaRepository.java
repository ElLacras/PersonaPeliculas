package com.clientes.personas.repository;

import com.clientes.personas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
    // Usamos interface en lugar de class porque:
    // Spring Data JPA se encarga de implementar automáticamente los métodos del repositorio
}
