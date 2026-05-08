package com.clientes.personas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Email(message = "Debe ser un correo válido")
    @NotBlank(message = "El email no puede estar vacío")
    @Column(unique = true)
    private String email;

    // Relación con microservicio de películas (solo IDs)
    // NO usamos @ManyToMany porque son microservicios distintos
    @ElementCollection
    private List<Integer> peliculasFavoritas;
}